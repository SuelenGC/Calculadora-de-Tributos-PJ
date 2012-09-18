package br.com.suelengc.calctributospj.view.activity;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.WindowManager;
import android.widget.Button;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.domain.TipoBaseCalculo;
import br.com.suelengc.calctributospj.domain.TipoTributacao;
import br.com.suelengc.calctributospj.preference.PreferenciasCalculo;
import br.com.suelengc.calctributospj.share.Email;
import br.com.suelengc.calctributospj.view.fragment.EntradaDadosCalculoValorBrutoFragment;
import br.com.suelengc.calctributospj.view.fragment.EntradaDadosCalculoValorPorHoraFragment;
import br.com.suelengc.calctributospj.view.fragment.SaidaDadosCalculoLucroPresumidoFragment;
import br.com.suelengc.calctributospj.view.fragment.SaidaDadosCalculoSimplesNacionalFragment;
import br.com.suelengc.calctributospj.view.listener.CalcularListener;
import br.com.suelengc.calctributospj.view.menu.MyMenu;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class CalculadoraActivity extends SherlockFragmentActivity {
	
	public static final String EXTRA_FORMATO_TELA = "1";
	Button btnCalcular;
	TipoBaseCalculo baseCalculo;
	
	PreferenciasCalculo preferencias;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        baseCalculo = (TipoBaseCalculo) getIntent().getSerializableExtra(EXTRA_FORMATO_TELA);

        GradientDrawable bg = (GradientDrawable) getResources().getDrawable(R.drawable.bg_gradient);
        getSupportActionBar().setBackgroundDrawable(bg);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
   
        //-- Impedir que o teclado seja aberto ao abrir a activity
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        
        //-- Carrega preferencias de calculo
        preferencias = new PreferenciasCalculo(getApplicationContext());
        
        if (savedInstanceState == null) {
        	//-- Cria fragment entrada
        	FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            SherlockFragment myFragmentDadosEntrada;
            
            //Escolhe qual fragment de entrada será apresentado a depender do tipo do tributo
            if (baseCalculo.equals(TipoBaseCalculo.VALOR_BRUTO)) {
            	setTitle("Cálculo pelo Valor Bruto");
            	myFragmentDadosEntrada = new EntradaDadosCalculoValorBrutoFragment();
            	ft.replace(R.id_calc.dadosEntradaCalculo, myFragmentDadosEntrada);
            	
            }else {
            	setTitle("Cálculo pelo Valor/Hora");
            	myFragmentDadosEntrada = new EntradaDadosCalculoValorPorHoraFragment();
            	ft.replace(R.id_calc.dadosEntradaCalculo, myFragmentDadosEntrada);
            }
            ft.commit();	
            
            //-- Cria fragment saida
            SherlockFragment myFragmentDadosSaida = null;
    		
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            
            if (preferencias.getTipoTributacao().equals(TipoTributacao.LUCRO_PRESUMIDO)) {
            	myFragmentDadosSaida = new SaidaDadosCalculoLucroPresumidoFragment();
            		
            }else if (preferencias.getTipoTributacao().equals(TipoTributacao.SIMPLES_NACIONAL)) {
            	myFragmentDadosSaida = new SaidaDadosCalculoSimplesNacionalFragment();
            }

            fragmentTransaction.replace(R.id_calc.dadosSaidaCalculo, myFragmentDadosSaida);
            fragmentTransaction.commit();
        }
        
   	}
		
	@Override
	protected void onStart() {
		super.onStart();
		
        CalcularListener calcularListener = new CalcularListener(preferencias, baseCalculo);
        
        btnCalcular = (Button) findViewById(R.id_calc.btcalcular);
		btnCalcular.setOnClickListener(calcularListener);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuInflater mi = new MenuInflater(getApplicationContext());
		mi.inflate(R.menu.menu, menu);
		
		//Ocultar menus desta tela
		menu.findItem(MyMenu.SETTINGS).setVisible(false);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = null;
		
		switch (item.getItemId()) {
		case MyMenu.HOME:
			finish();
			break;
			
		case MyMenu.ABOUT:
			intent = new Intent(this, AboutActivity.class);
			startActivity(intent);
			return true;
		
		case MyMenu.EMAIL:
			new Email().openIntentEmail(this);
			return false;
		}
		
		return super.onOptionsItemSelected(item);
		
	}
	
}
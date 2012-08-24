package br.com.suelengc.calctributospj.view.activity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.domain.TipoBaseCalculo;
import br.com.suelengc.calctributospj.domain.TipoTributacao;
import br.com.suelengc.calctributospj.preference.PreferenciasCalculo;
import br.com.suelengc.calctributospj.view.fragment.EntradaDadosCalculoValorBrutoFragment;
import br.com.suelengc.calctributospj.view.fragment.EntradaDadosCalculoValorPorHoraFragment;
import br.com.suelengc.calctributospj.view.fragment.SaidaDadosCalculoLucroPresumidoFragment;
import br.com.suelengc.calctributospj.view.fragment.SaidaDadosCalculoSimplesNacionalFragment;
import br.com.suelengc.calctributospj.view.listener.CalcularListener;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class CalculadoraActivity extends SherlockFragmentActivity {
	
	public static final String EXTRA_FORMATO_TELA = "1";
	Button btnCalcular;
	TipoBaseCalculo baseCalculo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        //String baseCalculo = getIntent().getStringExtra(EXTRA_FORMATO_TELA);
        baseCalculo = (TipoBaseCalculo) getIntent().getSerializableExtra(EXTRA_FORMATO_TELA);
        
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        
        SherlockFragment myFragmentDadosEntrada;
        
        //Escolhe qual fragment de entrada será apresentado 
        //a depender do tipo do tributo
        if (baseCalculo.equals(TipoBaseCalculo.VALOR_BRUTO)) {
        	setTitle("Cálculo Valor Bruto");
        	myFragmentDadosEntrada = new EntradaDadosCalculoValorBrutoFragment();
        	ft.replace(R.id_calc.dadosEntradaCalculo, myFragmentDadosEntrada);
        	
        }else {
        	setTitle("Cálculo Valor/Hora");
        	myFragmentDadosEntrada = new EntradaDadosCalculoValorPorHoraFragment();
        	ft.replace(R.id_calc.dadosEntradaCalculo, myFragmentDadosEntrada);
        }
        
        ft.commit();        
        
        GradientDrawable bg = (GradientDrawable) getResources().getDrawable(R.drawable.bg_gradient);
        getSupportActionBar().setBackgroundDrawable(bg);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		SherlockFragment myFragmentDadosSaida;
		
		PreferenciasCalculo preferencias = new PreferenciasCalculo(getApplicationContext());
        CalcularListener calcularListener = new CalcularListener(preferencias, baseCalculo);
        
        btnCalcular = (Button) findViewById(R.id_calc.btcalcular);
		btnCalcular.setOnClickListener(calcularListener);
		
        FragmentManager fm2 = getSupportFragmentManager();
        FragmentTransaction ft2 = fm2.beginTransaction();
        
        if (preferencias.getTipoTributacao().equals(TipoTributacao.LUCRO_PRESUMIDO)) {
        	myFragmentDadosSaida = new SaidaDadosCalculoLucroPresumidoFragment();
        	ft2.replace(R.id_calc.dadosSaidaCalculo, myFragmentDadosSaida);	
        }else if (preferencias.getTipoTributacao().equals(TipoTributacao.SIMPLES_NACIONAL)) {
        	myFragmentDadosSaida = new SaidaDadosCalculoSimplesNacionalFragment();
        	ft2.replace(R.id_calc.dadosSaidaCalculo, myFragmentDadosSaida);
        }
    	
        ft2.commit(); 
	}
}
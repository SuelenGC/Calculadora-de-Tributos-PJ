package br.com.suelengc.calctributospj.view.activity;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
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
	
	TextView tvvalor_bruto, tvvalor_liquido, tvirpj_retido, tvcofins_retido, tvpis_retido, tvcsll_retido, tvinss_darf, tvirpj_darf, tvcsll_darf, tvtotaldescontosmensais;
	TextView tvtributo_unificado;
	PreferenciasCalculo preferencias;
	//Bundle bundle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        baseCalculo = (TipoBaseCalculo) getIntent().getSerializableExtra(EXTRA_FORMATO_TELA);

        GradientDrawable bg = (GradientDrawable) getResources().getDrawable(R.drawable.bg_gradient);
        getSupportActionBar().setBackgroundDrawable(bg);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
   
        if(savedInstanceState != null){
        	/*
        	bundle = savedInstanceState;
			tvvalor_liquido = (TextView) findViewById(R.id_calc.valorliquido);
		    tvvalor_bruto = (TextView) findViewById(R.id_calc.valorbruto);
		    tvirpj_retido = (TextView) findViewById(R.id_calc.irpj_retido);
		    tvcofins_retido = (TextView) findViewById(R.id_calc.cofins_retido);
		    tvpis_retido = (TextView) findViewById(R.id_calc.pis_retido);
		    tvcsll_retido = (TextView) findViewById(R.id_calc.csll_retido);
		    tvinss_darf = (TextView) findViewById(R.id_calc.iss_darf);
		    tvirpj_darf = (TextView) findViewById(R.id_calc.irpj_darf);
		    tvcsll_darf = (TextView) findViewById(R.id_calc.csll_darf);
		    tvtotaldescontosmensais = (TextView) findViewById(R.id_calc.totaldescontosmensais);
		    */
		    
		    Toast.makeText(this, "Teste: " + savedInstanceState.getString("teste"), Toast.LENGTH_LONG).show();
	    	/*
		    tvvalor_liquido.setText(bundle.getString("valorliquido"));
	    	tvvalor_bruto.setText(bundle.getString("valorbruto"));
	    	tvirpj_retido.setText(bundle.getString("irpj_retido"));
	    	tvcofins_retido.setText(bundle.getString("cofins_retido"));
	    	tvpis_retido.setText(bundle.getString("pis_retido"));*/
	    	
        } //else {
        
    	FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        SherlockFragment myFragmentDadosEntrada;
        
        //Escolhe qual fragment de entrada será apresentado a depender do tipo do tributo
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
        //}        
   	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		SherlockFragment myFragmentDadosSaida = null;
		
		preferencias = new PreferenciasCalculo(getApplicationContext());
        CalcularListener calcularListener = new CalcularListener(preferencias, baseCalculo);
        
        btnCalcular = (Button) findViewById(R.id_calc.btcalcular);
		btnCalcular.setOnClickListener(calcularListener);
		
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
	
	@Override
	protected void onPause() {
		super.onPause();
		
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		
		//if (preferencias.getTipoTributacao().equals(TipoTributacao.LUCRO_PRESUMIDO)) {
			
			/*
			tvvalor_liquido = (TextView) findViewById(R.id_calc.valorliquido);
		    tvvalor_bruto = (TextView) findViewById(R.id_calc.valorbruto);
		    tvirpj_retido = (TextView) findViewById(R.id_calc.irpj_retido);
		    tvcofins_retido = (TextView) findViewById(R.id_calc.cofins_retido);
		    tvpis_retido = (TextView) findViewById(R.id_calc.pis_retido);
		    tvcsll_retido = (TextView) findViewById(R.id_calc.csll_retido);
		    tvinss_darf = (TextView) findViewById(R.id_calc.iss_darf);
		    tvirpj_darf = (TextView) findViewById(R.id_calc.irpj_darf);
		    tvcsll_darf = (TextView) findViewById(R.id_calc.csll_darf);
		    tvtotaldescontosmensais = (TextView) findViewById(R.id_calc.totaldescontosmensais);
		    
		    outState.putString("valorliquido", String.valueOf(tvvalor_liquido.getText()));
		    outState.putString("valorbruto", String.valueOf(tvvalor_bruto.getText()));
		    outState.putString("irpj_retido", String.valueOf(tvirpj_retido.getText()));
		    outState.putString("cofins_retido", String.valueOf(tvcofins_retido.getText()));
		    outState.putString("pis_retido", String.valueOf(tvpis_retido.getText()));
		    //outState.putString("csll_retido", "123");
		    //outState.putString("iss_darf", "123");
		    //outState.putString("irpj_darf", "123");
		    //outState.putString("csll_darf", "123");
		    //outState.putString("totaldescontosmensais", "123");
		    */
			
		outState.putString("teste", "123");
		//}else if (preferencias.getTipoTributacao().equals(TipoTributacao.SIMPLES_NACIONAL)) {
			//tvvalor_liquido = (TextView) findViewById(R.id_calc.valorliquido);
		    //tvvalor_bruto = (TextView) findViewById(R.id_calc.valorbruto);
		    //tvtotaldescontosmensais = (TextView) findViewById(R.id_calc.totaldescontosmensais);
			//tvtributo_unificado = (TextView) findViewById(R.id_calc.tributo_unificado);
        //}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuInflater mi = new MenuInflater(getApplicationContext());
		mi.inflate(R.menu.menu, menu);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MyMenu.HOME:
			finish();
			
		case MyMenu.EMAIL:
			new Email().sendEmail(this);
		}
		
		return super.onOptionsItemSelected(item);
		
	}
	
}
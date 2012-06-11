package br.com.suelengc.calctributospj.view.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.domain.TipoBaseCalculo;
import br.com.suelengc.calctributospj.domain.TipoTributacao;
import br.com.suelengc.calctributospj.preference.*;
import br.com.suelengc.calctributospj.view.activity.listener.CalcularListener;

public class CalcActivity extends Activity implements BaseActivity {
	private static final int SOBRE = Menu.FIRST;
	
    TableRow trValorHora1, trValorHora2, trValor;
    TableLayout frmLucroPresumido, frmSimplesNacional;
    
    Button btcalcular;
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.calc);
        setTitle("Calculadora de Tributos PJ - Principal");
    
        getScreenInformation(); 
        
        //Lógica para exibição dos campo de entradas de dados
        TipoBaseCalculo baseCalculo;
        baseCalculo = (TipoBaseCalculo) getIntent().getSerializableExtra(MenuActivity.EXTRA_FORMATO_TELA);
        LoadInputDataScreen(baseCalculo);
        
        //Lógica para exibição dos tributos a serem exibido/saída de dados
        //TipoTributacao tipoTributacao = (TipoTributacao) Preferencias.getPreferenciaValorInteiro(CalcActivity.this, "TipoTributacao");
        //Mudar aqui
        LoadOutputDataScreen(TipoTributacao.LUCRO_PRESUMIDO);
        
        btcalcular = (Button) findViewById(R.id_calc.btcalcular);
        btcalcular.setOnClickListener(new CalcularListener(baseCalculo, this));

    }
    
	public void getScreenInformation() {
        trValorHora1 = (TableRow) findViewById(R.id_calc.tr_valorhora1);
        trValorHora2 = (TableRow) findViewById(R.id_calc.tr_valorhora2);
        trValor = (TableRow) findViewById(R.id_calc.tr_valor);		
	}
	
	private void LoadInputDataScreen(TipoBaseCalculo baseCalculo) {
        if (baseCalculo == TipoBaseCalculo.VALOR_BRUTO) {
        	trValorHora1.setVisibility(View.GONE);
        	trValorHora2.setVisibility(View.GONE);
        	trValor.setVisibility(View.VISIBLE);
        	
        } else if (baseCalculo == TipoBaseCalculo.VALOR_HORA) {
        	trValorHora1.setVisibility(View.VISIBLE);
        	trValorHora2.setVisibility(View.VISIBLE);
        	trValor.setVisibility(View.GONE);
        }
	}
	
    private void LoadOutputDataScreen(TipoTributacao tipoTributacao) {
        frmLucroPresumido = (TableLayout) findViewById(R.id_calc.frmLucroPresumido);
        frmSimplesNacional = (TableLayout) findViewById(R.id_calc.frmSimplesNacional);
        
		if(tipoTributacao == TipoTributacao.LUCRO_PRESUMIDO) {  
		    frmLucroPresumido.setVisibility(View.VISIBLE);
		    frmSimplesNacional.setVisibility(View.GONE);
			
	    } else if(tipoTributacao == TipoTributacao.SIMPLES_NACIONAL) {  
	    	frmLucroPresumido.setVisibility(View.GONE);
	    	frmSimplesNacional.setVisibility(View.VISIBLE);
	    }  
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, SOBRE, 0, "Sobre!");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case SOBRE:
			Intent intent = new Intent(this, InformationActivity.class);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
package br.com.suelengc.calctributospj.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.domain.TypeBaseCalculation;
import br.com.suelengc.calctributospj.domain.TypeTaxation;
import br.com.suelengc.calctributospj.view.activity.listener.CalculateListener;

public class CalculationActivity extends Activity implements BaseActivity {
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
        TypeBaseCalculation baseCalculo;
        baseCalculo = (TypeBaseCalculation) getIntent().getSerializableExtra(MenuActivity.EXTRA_FORMATO_TELA);
        LoadInputDataScreen(baseCalculo);
        
        //Lógica para exibição dos tributos a serem exibido/saída de dados
        //TipoTributacao tipoTributacao = (TipoTributacao) Preferencias.getPreferenciaValorInteiro(CalcActivity.this, "TipoTributacao");
        //Mudar aqui
        LoadOutputDataScreen(TypeTaxation.LUCRO_PRESUMIDO);
        
        btcalcular = (Button) findViewById(R.id_calc.btcalcular);
        btcalcular.setOnClickListener(new CalculateListener(baseCalculo, this));

    }
    
	public void getScreenInformation() {
        trValorHora1 = (TableRow) findViewById(R.id_calc.tr_valorhora1);
        trValorHora2 = (TableRow) findViewById(R.id_calc.tr_valorhora2);
        trValor = (TableRow) findViewById(R.id_calc.tr_valor);		
	}
	
	private void LoadInputDataScreen(TypeBaseCalculation baseCalculo) {
        if (baseCalculo == TypeBaseCalculation.VALOR_BRUTO) {
        	trValorHora1.setVisibility(View.GONE);
        	trValorHora2.setVisibility(View.GONE);
        	trValor.setVisibility(View.VISIBLE);
        	
        } else if (baseCalculo == TypeBaseCalculation.VALOR_HORA) {
        	trValorHora1.setVisibility(View.VISIBLE);
        	trValorHora2.setVisibility(View.VISIBLE);
        	trValor.setVisibility(View.GONE);
        }
	}
	
    private void LoadOutputDataScreen(TypeTaxation tipoTributacao) {
        frmLucroPresumido = (TableLayout) findViewById(R.id_calc.frmLucroPresumido);
        frmSimplesNacional = (TableLayout) findViewById(R.id_calc.frmSimplesNacional);
        
		if(tipoTributacao == TypeTaxation.LUCRO_PRESUMIDO) {  
		    frmLucroPresumido.setVisibility(View.VISIBLE);
		    frmSimplesNacional.setVisibility(View.GONE);
			
	    } else if(tipoTributacao == TypeTaxation.SIMPLES_NACIONAL) {  
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
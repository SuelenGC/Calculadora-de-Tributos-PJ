package br.com.suelengc.calctributospj.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.utils.*;

public class CalcActivity extends Activity {
	private static final int INFORMACOES = Menu.FIRST;
	
    TableRow trValorHora1, trValorHora2, trValor;
    TableLayout frmLucroPresumido, frmSimplesNacional;
    
    Button btcalcular;
    int formatoTela;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.calc);
        setTitle("Calculadora de Tributos PJ - Principal");
    
        trValorHora1 = (TableRow) findViewById(R.id_calc.tr_valorhora1);
        trValorHora2 = (TableRow) findViewById(R.id_calc.tr_valorhora2);
        trValor = (TableRow) findViewById(R.id_calc.tr_valor);

        Intent intent = getIntent();
        
        formatoTela = Integer.parseInt(intent.getStringExtra(MenuActivity.EXTRA_FORMATO_TELA));
        
        if (formatoTela == FormatoTela.CALCULO_POR_VALOR_BRUTO) {
        	ExibirTelaValorBruto();
        } else if (formatoTela == FormatoTela.CALCULO_POR_VALOR_HORA) {
        	ExibirTelaValorHora();
        }
        
        int tipoTributacao = Preferencias.getPreferenciaValorInteiro(CalcActivity.this, "TipoTributacao");
        if (tipoTributacao == 1) {
        	FormataTela(1);
        } else if (tipoTributacao == 2) {
        	FormataTela(2);
        }
        
        btcalcular = (Button) findViewById(R.id_calc.btcalcular);
        btcalcular.setOnClickListener(new CalcularListener(formatoTela, this));

    }
    
    private void ExibirTelaValorBruto() {
    	trValorHora1.setVisibility(View.GONE);
    	trValorHora2.setVisibility(View.GONE);
    	trValor.setVisibility(View.VISIBLE);
    }
    
    private void ExibirTelaValorHora() {
    	trValorHora1.setVisibility(View.VISIBLE);
    	trValorHora2.setVisibility(View.VISIBLE);
    	trValor.setVisibility(View.GONE);
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, INFORMACOES, 0, "Informações...");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case INFORMACOES:
			Intent intent = new Intent(this, InfoActivity.class);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
    private void FormataTela(int TipoTributacaoEscolhida) {
        frmLucroPresumido = (TableLayout) findViewById(R.id_calc.frmLucroPresumido);
        frmSimplesNacional = (TableLayout) findViewById(R.id_calc.frmSimplesNacional);
        
		if(TipoTributacaoEscolhida == 1) {  
		    frmLucroPresumido.setVisibility(View.VISIBLE);
		    frmSimplesNacional.setVisibility(View.GONE);
			
	    } else if(TipoTributacaoEscolhida == 2) {  
	    	frmLucroPresumido.setVisibility(View.GONE);
	    	frmSimplesNacional.setVisibility(View.VISIBLE);
	    }  
    }
}
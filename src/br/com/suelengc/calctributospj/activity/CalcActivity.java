package br.com.suelengc.calctributospj.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.utils.*;

public class CalcActivity extends Activity {
	private static final int CONFIGURACOES = Menu.FIRST;
	private static final int INFORMACOES = Menu.FIRST+1;
	
    TableRow trValorHora1, trValorHora2, trValor;

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
        
        btcalcular = (Button) findViewById(R.id_calc.btcalcular);
        btcalcular.setOnClickListener(new CalcularListener(formatoTela));
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
		menu.add(0, CONFIGURACOES, 0, "Configurações");
		menu.add(0, INFORMACOES, 0, "Informações");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case INFORMACOES:
			AlertDialog.Builder infos = new AlertDialog.Builder(CalcActivity.this);
			infos.setTitle("Desenvolvedor");
			infos.setMessage("Suelen G. Carvalho \n" +
							 "www.suelengc.com.br \n" +
							 "suelengcarvalho@gmail.com \n" +
							 "Versão 2.1");
			infos.setNeutralButton("Fechar", null);
			infos.show();
			
			return true;
		case CONFIGURACOES:
			startActivity(new Intent(this, ConfigActivity.class));
						
			return true;
			
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
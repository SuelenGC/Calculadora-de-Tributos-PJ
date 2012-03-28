package br.com.suelengc.calctributospj.activity;

import java.text.NumberFormat;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.media.ExifInterface;
import android.os.Bundle;
import android.widget.*;
import android.text.style.IconMarginSpan;
import android.view.*;
import br.com.suelengc.utils.*;
import br.com.suelengc.calctributospj.controller.*;
import br.com.suelengc.calctributospj.model.TributacaoNormal;
import br.com.calctributospj.R;

public class CalcActivity extends Activity {
	private static final int INFORMACOES = Menu.FIRST+1;
	private static final int SAIR = Menu.FIRST+2;
	
    EditText edvalorhora, edtotalhoras;
	TextView tvvalor_bruto, tvvalor_liquido, tvirpj_retido, tvcofins_retido, tvpis_retido, tvcsll_retido, tvinss_darf, tvirpj_darf, tvcsll_darf;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);
        setTitle("Cálculo de Tributos PJ");
        
        //Entrada de dados
        edvalorhora = (EditText) findViewById(R.id.valorhora);
        edtotalhoras = (EditText) findViewById(R.id.totalhoras);
        
        //Saída de dados
        tvvalor_liquido = (TextView) findViewById(R.id.valorliquido);
        tvvalor_bruto = (TextView) findViewById(R.id.valorbruto);
        tvirpj_retido = (TextView) findViewById(R.id.irpj_retido);
        tvcofins_retido = (TextView) findViewById(R.id.cofins_retido);
        tvpis_retido = (TextView) findViewById(R.id.pis_retido);
        tvcsll_retido = (TextView) findViewById(R.id.csll_retido);
        tvinss_darf = (TextView) findViewById(R.id.inss_darf);
        tvirpj_darf = (TextView) findViewById(R.id.irpj_darf);
        tvcsll_darf = (TextView) findViewById(R.id.csll_darf);
        
        Button btcalcular = (Button) findViewById(R.id.btcalcular);
        
        btcalcular.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		        
				double valorhora = 0, totalhoras = 0;
		        
		        if (Validators.ValidaEditText(edvalorhora) && Validators.ValidaEditText(edtotalhoras)) {
		        	
		        	TributacaoNormal objTributacaoNormal;
		        	
			        valorhora = Double.parseDouble(edvalorhora.getText().toString());
			        totalhoras = Double.parseDouble(edtotalhoras.getText().toString());
			        
			        objTributacaoNormal = new TributacaoController().CalculaTributos(valorhora, totalhoras);
			        
			        tvvalor_bruto.setText("R$ " + Formaters.DoubleToString(objTributacaoNormal.getValorBrutoNotaFiscal()));
			        tvirpj_retido.setText("R$ " + Formaters.DoubleToString(objTributacaoNormal.getIrpjMensal()));
			        tvcofins_retido.setText("R$ " + Formaters.DoubleToString(objTributacaoNormal.getCofinsMensal()));
			        tvpis_retido.setText("R$ " + Formaters.DoubleToString(objTributacaoNormal.getPisMensal()));
			        tvcsll_retido.setText("R$ " + Formaters.DoubleToString(objTributacaoNormal.getCsllMensal()));
			        tvvalor_liquido.setText("R$ " + Formaters.DoubleToString(objTributacaoNormal.getValorLiquidoNotaFiscal()));
			        tvinss_darf.setText("R$ " + Formaters.DoubleToString(objTributacaoNormal.getInssMensal()));
			        
			        tvirpj_darf.setText("R$ " + Formaters.DoubleToString(objTributacaoNormal.getIrpjTrimestral()));
			        tvcsll_darf.setText("R$ " + Formaters.DoubleToString(objTributacaoNormal.getCsllTrimetral()));
			        
			        Intent i = new Intent(CalcActivity.this, SecondActivity.class);
					startActivity(i);
					
		        }
			}

		});
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, INFORMACOES, 0, "Informações");
		menu.add(0, SAIR, 0, "Sair");
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
							 "suelengcarvalho@gmail.com \n");
			infos.setNeutralButton("Fechar", null);
			infos.show();
			
			return true;
		case SAIR:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
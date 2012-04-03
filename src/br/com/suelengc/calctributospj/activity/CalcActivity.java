package br.com.suelengc.calctributospj.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import br.com.suelengc.utils.*;
import br.com.suelengc.calctributospj.controller.*;
import br.com.suelengc.calctributospj.model.TributacaoNormal;
import br.com.suelengc.calctributospj.R;

public class CalcActivity extends Activity {
	private static final int CONFIGURACOES = Menu.FIRST;
	private static final int INFORMACOES = Menu.FIRST+1;
	
    EditText edvalorhora, edtotalhoras;
	TextView tvvalor_bruto, tvvalor_liquido, tvirpj_retido, tvcofins_retido, tvpis_retido, tvcsll_retido, tvinss_darf, tvirpj_darf, tvcsll_darf, tvtotaldescontosmensais;
	
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
        tvtotaldescontosmensais = (TextView) findViewById(R.id.totaldescontosmensais);
        
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
			        tvinss_darf.setText("R$ " + Formaters.DoubleToString(objTributacaoNormal.getIssMensal()));
			        
			        tvirpj_darf.setText("R$ " + Formaters.DoubleToString(objTributacaoNormal.getIrpjTrimestral()));
			        tvtotaldescontosmensais.setText("R$ " + Formaters.DoubleToString(objTributacaoNormal.getTotalDescontosMensais()));
			        tvcsll_darf.setText("R$ " + Formaters.DoubleToString(objTributacaoNormal.getCsllTrimetral()));
		        }
			}

		});
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
							 "suelengcarvalho@gmail.com \n");
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
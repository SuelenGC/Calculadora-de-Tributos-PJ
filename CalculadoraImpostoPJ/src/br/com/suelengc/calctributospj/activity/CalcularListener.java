package br.com.suelengc.calctributospj.activity;

import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.controller.NotaFiscalController;
import br.com.suelengc.calctributospj.model.NotaFiscal;
import br.com.suelengc.calctributospj.model.TributosLucroPresumido;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import br.com.suelengc.utils.*;

public class CalcularListener implements OnClickListener {

	EditText edvalorhora, edtotalhoras, edvalor;
	TextView tvvalor_bruto, tvvalor_liquido, tvirpj_retido, tvcofins_retido, tvpis_retido, tvcsll_retido, tvinss_darf, tvirpj_darf, tvcsll_darf, tvtotaldescontosmensais;

	private double valorHora, qtdeHoras, valorBruto, valorTotalNotaFiscal;
	private int formatoTela;
	NotaFiscalController notaFiscalController;
	
	public CalcularListener(int formatoTela) {
		this.formatoTela = formatoTela; 
	}
	
	public void onClick(View v) {
		
		View p = (View) v.getRootView();
		
		if (p != null) {
			tvvalor_liquido = (TextView) p.findViewById(R.id_calc.valorliquido);
		    tvvalor_bruto = (TextView) p.findViewById(R.id_calc.valorbruto);
		    tvirpj_retido = (TextView) p.findViewById(R.id_calc.irpj_retido);
		    tvcofins_retido = (TextView) p.findViewById(R.id_calc.cofins_retido);
		    tvpis_retido = (TextView) p.findViewById(R.id_calc.pis_retido);
		    tvcsll_retido = (TextView) p.findViewById(R.id_calc.csll_retido);
		    tvinss_darf = (TextView) p.findViewById(R.id_calc.inss_darf);
		    tvirpj_darf = (TextView) p.findViewById(R.id_calc.irpj_darf);
		    tvcsll_darf = (TextView) p.findViewById(R.id_calc.csll_darf);
		    tvtotaldescontosmensais = (TextView) p.findViewById(R.id_calc.totaldescontosmensais);

			if (formatoTela  == FormatoTela.CALCULO_POR_VALOR_HORA) {
			    edvalorhora = (EditText) p.findViewById(R.id_calc.valorhora);
			    edtotalhoras = (EditText) p.findViewById(R.id_calc.totalhoras);
			    
			    valorHora = Double.parseDouble(edvalorhora.getText().toString());
			    qtdeHoras = Double.parseDouble(edtotalhoras.getText().toString());
			    
			    notaFiscalController = new NotaFiscalController(valorHora, qtdeHoras);
			    
			} else if (formatoTela == FormatoTela.CALCULO_POR_VALOR_BRUTO) { 
				edvalor = (EditText) p.findViewById(R.id_calc.valorBruto);
				
				Log.d("S-DEBUG-CALC", "Chegou aqui");
				
				valorBruto = Double.parseDouble(edvalor.getText().toString());
				valorTotalNotaFiscal = valorBruto;
				
				notaFiscalController = new NotaFiscalController(valorTotalNotaFiscal);
			}
			
			NotaFiscal notaFiscal = notaFiscalController.getNotaFiscal();
			
			if (notaFiscal.getValorBruto() > 0.0) {
				TributosLucroPresumido tributos = (TributosLucroPresumido) notaFiscal.getTributos();
			
				tvirpj_retido.setText("R$ " + Formaters.DoubleToString(tributos.getIrpjMensal()));
				tvcofins_retido.setText("R$ " + Formaters.DoubleToString(tributos.getCofinsMensal()));
				tvpis_retido.setText("R$ " + Formaters.DoubleToString(tributos.getPisMensal()));
				tvcsll_retido.setText("R$ " + Formaters.DoubleToString(tributos.getCsllMensal()));
				
				tvinss_darf.setText("R$ " + Formaters.DoubleToString(tributos.getIssMensal()));
				tvirpj_darf.setText("R$ " + Formaters.DoubleToString(tributos.getIrpjTrimestral()));
				tvcsll_darf.setText("R$ " + Formaters.DoubleToString(tributos.getCsllTrimetral()));
				
				tvvalor_bruto.setText("R$ " + Formaters.DoubleToString(notaFiscal.getValorBruto()));
				tvtotaldescontosmensais.setText("R$ " + Formaters.DoubleToString(tributos.getValorTotalDescontos()));
				tvvalor_liquido.setText("R$ " + Formaters.DoubleToString(notaFiscal.getValorLiquido()));
			}		
		}
	}
}

package br.com.suelengc.calctributospj.activity;

import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.controller.NotaFiscalController;
import br.com.suelengc.calctributospj.model.NotaFiscal;
import br.com.suelengc.calctributospj.model.TributosLucroPresumido;
import br.com.suelengc.calctributospj.model.TributosSimples;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import br.com.suelengc.utils.*;

public class CalcularListener implements OnClickListener {

	EditText edvalorhora, edtotalhoras, edvalor;
	TextView tvvalor_bruto, tvvalor_liquido, tvirpj_retido, tvcofins_retido, tvpis_retido, tvcsll_retido, tvinss_darf, tvirpj_darf, tvcsll_darf, tvtotaldescontosmensais;
	TextView tvvalor_bruto2, tvvalor_liquido2, tvtotaldescontosmensais2, tvtributo_unificado;

	private double valorHora, qtdeHoras, valorBruto, valorTotalNotaFiscal;
	private int formatoTela;
	NotaFiscalController notaFiscalController;
	
	public CalcularListener(int formatoTela, Context contexto) {
		this.formatoTela = formatoTela; 
	}
	
	
	public void onClick(View v) {
		
		View p = (View) v.getRootView();
		int tipoTributacao = 1;
		float percIRPJ = 2.4f;
		NotaFiscal notaFiscal = null;
		
		if (p != null) {

			edvalor = (EditText) p.findViewById(R.id_calc.valorBruto);
		    edvalorhora = (EditText) p.findViewById(R.id_calc.valorhora);
		    edtotalhoras = (EditText) p.findViewById(R.id_calc.totalhoras);
		    
			if (Preferencias.getPreferenciaValorInteiro(p.getContext(), "TipoTributacao") == 1) {//LUCRO PRESUMIDO
				tipoTributacao = 1;
			} else { //SIMPLES NACIONAL
				tipoTributacao = 2;
			}
			
			percIRPJ = Preferencias.getPreferenciaValorFloat(p.getContext(), "PercIRPJ");
			
			if (formatoTela  == FormatoTela.CALCULO_POR_VALOR_HORA) {
				
			    if (Validators.ValidaEditText(edvalorhora) && Validators.ValidaEditText(edtotalhoras)) {

					valorHora = Double.parseDouble(edvalorhora.getText().toString());
				    qtdeHoras = Double.parseDouble(edtotalhoras.getText().toString());
				    
				    notaFiscalController = new NotaFiscalController(valorHora, qtdeHoras, tipoTributacao, percIRPJ);
			    } else return;
			    
			} else if (formatoTela == FormatoTela.CALCULO_POR_VALOR_BRUTO) { 
				
				if (Validators.ValidaEditText(edvalor)) {
					valorBruto = Double.parseDouble(edvalor.getText().toString());
					valorTotalNotaFiscal = valorBruto;
					
					notaFiscalController = new NotaFiscalController(valorTotalNotaFiscal, tipoTributacao, percIRPJ);
				} else return;
			}
			
			if (notaFiscalController != null && notaFiscalController.getNotaFiscal().getValorBruto() > 0.0) {
			
				notaFiscal = notaFiscalController.getNotaFiscal();
			
				if (tipoTributacao == 1) {
					TributosLucroPresumido tributos = (TributosLucroPresumido) notaFiscal.getTributos();
					
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
					
				} else if (tipoTributacao == 2) {
					TributosSimples tributos = (TributosSimples) notaFiscal.getTributos();
				    
					tvvalor_liquido2 = (TextView) p.findViewById(R.id_calc.valorliquido2);
				    tvvalor_bruto2 = (TextView) p.findViewById(R.id_calc.valorbruto2);
				    tvtotaldescontosmensais2 = (TextView) p.findViewById(R.id_calc.totaldescontosmensais2);
				    
					tvtributo_unificado = (TextView) p.findViewById(R.id_calc.tributo_unificado);
					tvtributo_unificado.setText("R$ " + Formaters.DoubleToString(tributos.getValorTotalDescontos()));
					
					tvvalor_bruto2.setText("R$ " + Formaters.DoubleToString(notaFiscal.getValorBruto()));
					tvtotaldescontosmensais2.setText("R$ " + Formaters.DoubleToString(tributos.getValorTotalDescontos()));
					tvvalor_liquido2.setText("R$ " + Formaters.DoubleToString(notaFiscal.getValorLiquido()));
				}
			}	
		}
	}
}

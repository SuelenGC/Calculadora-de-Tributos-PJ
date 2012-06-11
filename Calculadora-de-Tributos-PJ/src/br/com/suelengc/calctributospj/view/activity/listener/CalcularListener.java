package br.com.suelengc.calctributospj.view.activity.listener;

import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.controller.NotaFiscalController;
import br.com.suelengc.calctributospj.domain.TipoBaseCalculo;
import br.com.suelengc.calctributospj.model.NotaFiscal;
import br.com.suelengc.calctributospj.model.TributosLucroPresumido;
import br.com.suelengc.calctributospj.model.TributosSimples;
import br.com.suelengc.calctributospj.preference.*;
import br.com.suelengc.calctributospj.view.controller.Formatadores;
import br.com.suelengc.calctributospj.view.controller.Validadores;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class CalcularListener implements OnClickListener {

	EditText edvalorhora, edtotalhoras, edvalor;
	TextView tvvalor_bruto, tvvalor_liquido, tvirpj_retido, tvcofins_retido, tvpis_retido, tvcsll_retido, tvinss_darf, tvirpj_darf, tvcsll_darf, tvtotaldescontosmensais;
	TextView tvvalor_bruto2, tvvalor_liquido2, tvtotaldescontosmensais2, tvtributo_unificado;

	private double valorHora, qtdeHoras, valorBruto, valorTotalNotaFiscal;
	private TipoBaseCalculo baseCalculo;
	NotaFiscalController notaFiscalController;
	
	public CalcularListener(TipoBaseCalculo baseCalculo, Context contexto) {
		this.baseCalculo = baseCalculo; 
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
			
			if (baseCalculo  == TipoBaseCalculo.VALOR_HORA) {
				
			    if (Validadores.ValidaEditText(edvalorhora) && Validadores.ValidaEditText(edtotalhoras)) {

					valorHora = Double.parseDouble(edvalorhora.getText().toString());
				    qtdeHoras = Double.parseDouble(edtotalhoras.getText().toString());
				    
				    notaFiscalController = new NotaFiscalController(valorHora, qtdeHoras, tipoTributacao, percIRPJ);
			    } else return;
			    
			} else if (baseCalculo == TipoBaseCalculo.VALOR_BRUTO) { 
				
				if (Validadores.ValidaEditText(edvalor)) {
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
				    tvinss_darf = (TextView) p.findViewById(R.id_calc.iss_darf);
				    tvirpj_darf = (TextView) p.findViewById(R.id_calc.irpj_darf);
				    tvcsll_darf = (TextView) p.findViewById(R.id_calc.csll_darf);
				    tvtotaldescontosmensais = (TextView) p.findViewById(R.id_calc.totaldescontosmensais);
				    
					tvirpj_retido.setText("R$ " + Formatadores.DoubleToString(tributos.getIrpjMensal()));
					tvcofins_retido.setText("R$ " + Formatadores.DoubleToString(tributos.getCofinsMensal()));
					tvpis_retido.setText("R$ " + Formatadores.DoubleToString(tributos.getPisMensal()));
					tvcsll_retido.setText("R$ " + Formatadores.DoubleToString(tributos.getCsllMensal()));
					
					tvinss_darf.setText("R$ " + Formatadores.DoubleToString(tributos.getIssMensal()));
					tvirpj_darf.setText("R$ " + Formatadores.DoubleToString(tributos.getIrpjTrimestral()));
					tvcsll_darf.setText("R$ " + Formatadores.DoubleToString(tributos.getCsllTrimetral()));

					tvvalor_bruto.setText("R$ " + Formatadores.DoubleToString(notaFiscal.getValorBruto()));
					tvtotaldescontosmensais.setText("R$ " + Formatadores.DoubleToString(tributos.getValorTotalDescontos()));
					tvvalor_liquido.setText("R$ " + Formatadores.DoubleToString(notaFiscal.getValorLiquido()));
					
				} else if (tipoTributacao == 2) {
					TributosSimples tributos = (TributosSimples) notaFiscal.getTributos();
				    
					tvvalor_liquido2 = (TextView) p.findViewById(R.id_calc.valorliquido2);
				    tvvalor_bruto2 = (TextView) p.findViewById(R.id_calc.valorbruto2);
				    tvtotaldescontosmensais2 = (TextView) p.findViewById(R.id_calc.totaldescontosmensais2);
				    
					tvtributo_unificado = (TextView) p.findViewById(R.id_calc.tributo_unificado);
					tvtributo_unificado.setText("R$ " + Formatadores.DoubleToString(tributos.getValorTotalDescontos()));
					
					tvvalor_bruto2.setText("R$ " + Formatadores.DoubleToString(notaFiscal.getValorBruto()));
					tvtotaldescontosmensais2.setText("R$ " + Formatadores.DoubleToString(tributos.getValorTotalDescontos()));
					tvvalor_liquido2.setText("R$ " + Formatadores.DoubleToString(notaFiscal.getValorLiquido()));
				}
			}	
		}
	}
}

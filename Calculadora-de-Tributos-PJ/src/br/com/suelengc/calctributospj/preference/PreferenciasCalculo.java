package br.com.suelengc.calctributospj.preference;

import android.content.Context;
import br.com.suelengc.calctributospj.domain.PercentualIRPJ;
import br.com.suelengc.calctributospj.domain.TipoTributacao;
import br.com.suelengc.calctributospj.view.controller.Formatter;

public class PreferenciasCalculo {

	private final int LUCRO_PRESUMIDO = 1;
	private final int SIMPLES_NACIONAL = 2;
	
	private final int DOIS_PONTO_QUADRO = 1;
	private final int QUATRO_PONTO_OITO = 2;
	
	Preferencias preferencias;
	
	public PreferenciasCalculo(Context context) {
		this.preferencias = new Preferencias(context);
	}
	
	public TipoTributacao getTipoTributacao() {
		TipoTributacao retorno = null;
		int tributacao = 1;
		
		if (preferencias.getString("TipoTributacao") != null) {
			tributacao = Integer.parseInt(preferencias.getString("TipoTributacao"));	
		}
				
		if (tributacao == LUCRO_PRESUMIDO){
			retorno = TipoTributacao.LUCRO_PRESUMIDO;
		}else if (tributacao == SIMPLES_NACIONAL) {
			retorno = TipoTributacao.SIMPLES_NACIONAL;
		}else {
			retorno = TipoTributacao.LUCRO_PRESUMIDO ;
		}
		
		return retorno;
	}

	public PercentualIRPJ getPercentIRPJ() {
		PercentualIRPJ retorno = null;
		int percIRPJ = 1;
		
		if (preferencias.getString("PercentualIRPJ") != null) {
			percIRPJ = Integer.parseInt(preferencias.getString("PercentualIRPJ"));	
		}
		
		if (percIRPJ == DOIS_PONTO_QUADRO){
			retorno = PercentualIRPJ.DOIS_PONTO_QUATRO;
		}else if (percIRPJ == QUATRO_PONTO_OITO) {
			retorno = PercentualIRPJ.QUATRO_PONTO_OITO;
		}else {
			retorno = PercentualIRPJ.DOIS_PONTO_QUATRO;
		}
		
		return retorno;
	}
	
	public float getPercentISS() {
		float retorno = 0;
		
		if (preferencias.getString("PencentualISS") != null) {
			retorno = Float.parseFloat(new Formatter().commaToDot(preferencias.getString("PencentualISS")));	
		}
		
		return retorno;
	}
}

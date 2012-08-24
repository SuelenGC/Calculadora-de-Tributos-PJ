package br.com.suelengc.calctributospj.preference;

import android.content.Context;
import br.com.suelengc.calctributospj.domain.PercentualIRPJ;
import br.com.suelengc.calctributospj.domain.TipoTributacao;

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
		int tributacao = preferencias.getInt("TipoTributacao");
		
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
		int percIRPJ = preferencias.getInt("PercIRPJ");
		
		if (percIRPJ == DOIS_PONTO_QUADRO){
			retorno = PercentualIRPJ.DOIS_PONTO_QUATRO;
		}else if (percIRPJ == QUATRO_PONTO_OITO) {
			retorno = PercentualIRPJ.QUATRO_PONTO_OITO;
		}else {
			retorno = PercentualIRPJ.DOIS_PONTO_QUATRO;
		}
		
		return retorno;
	}
}

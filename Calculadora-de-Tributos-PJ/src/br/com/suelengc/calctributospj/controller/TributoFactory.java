package br.com.suelengc.calctributospj.controller;

import br.com.suelengc.calctributospj.domain.TipoTributacao;
import br.com.suelengc.calctributospj.model.LucroPresumido;
import br.com.suelengc.calctributospj.model.SimplesNacional;
import br.com.suelengc.calctributospj.model.Tributo;
import br.com.suelengc.calctributospj.preference.PreferenciasCalculo;

public class TributoFactory {

	public Tributo Create(PreferenciasCalculo preferencias) {
		Tributo tributo = null;
		
		if (preferencias.getTipoTributacao().equals(TipoTributacao.LUCRO_PRESUMIDO)) {
			tributo = new LucroPresumido(preferencias.getPercentIRPJ(), preferencias.getPercentISS());
		
		} else if (preferencias.getTipoTributacao().equals(TipoTributacao.SIMPLES_NACIONAL)) {
			tributo = new SimplesNacional();
		
		}
		return tributo;
	}

}

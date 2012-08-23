package br.com.suelengc.calctributospj.model;

import br.com.suelengc.calctributospj.domain.PercentualIRPJ;

public interface Tributo {
	public double valorTotalTributos();

	public void Calcular(double valorBruto); 
}

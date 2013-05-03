package br.com.suelengc.calctributospj.model;

import br.com.suelengc.calctributospj.view.controller.Formatter;

public class SimplesNacional implements Tributo {
	private double tributoUnificado;

	public double getTributoUnificado() {
		return tributoUnificado;
	}

	@Override
	public double getValorTotalTributos() {
		return tributoUnificado;
	}

	@Override
	public void Calcular(double valorBruto) {
		this.tributoUnificado = valorBruto * 0.06;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("Tributo Unificado: R$ " + Formatter.DoubleToString(getValorTotalTributos()));

		return builder.toString();
	}
}

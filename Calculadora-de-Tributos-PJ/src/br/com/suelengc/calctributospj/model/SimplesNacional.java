package br.com.suelengc.calctributospj.model;

public class SimplesNacional implements Tributo {
	private double tributoUnificado;
	
	public double getTributoUnificado() {
		return tributoUnificado;		
	}

	@Override
	public double valorTotalTributos() {
		return tributoUnificado;
	}

	@Override
	public void Calcular(double valorBruto) {
		this.tributoUnificado = valorBruto * 0.06;
	}
}

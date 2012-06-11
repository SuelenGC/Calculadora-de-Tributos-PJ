package br.com.suelengc.calctributospj.model;

public class TaxSimple implements Tax{
	private double tributoUnificado;
	
	public TaxSimple (double valorTotalNotaFiscal) {
		setTributoUnificado(valorTotalNotaFiscal);
	}

	private void setTributoUnificado(double valorTotalNotaFiscal) {
		tributoUnificado = valorTotalNotaFiscal * 0.06;		
	}

	private double getTributoUnificado() {
		return tributoUnificado;		
	}
	
	public double getValorTotalDescontos() {
		return getTributoUnificado();
	}
	
}

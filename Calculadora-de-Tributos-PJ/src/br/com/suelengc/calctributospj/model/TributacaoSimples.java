package br.com.suelengc.calctributospj.model;

public class TributacaoSimples implements Tributacao{
	private double tributoUnificado;
	
	public TributacaoSimples (double valorTotalNotaFiscal) {
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

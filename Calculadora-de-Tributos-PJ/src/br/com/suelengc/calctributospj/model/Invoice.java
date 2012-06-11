package br.com.suelengc.calctributospj.model;

public class Invoice {

	private double valorBruto;
	private double valorLiquido;
	private Tax tributos;  
	
	public Invoice(double valorTotalNotaFiscal, Tax tributos) {
		setValorBruto(valorTotalNotaFiscal);
		setTributos(tributos);
		setValorLiquido();		
	}

	public void setTributos(Tax tributo) {
		this.tributos = tributo;
	}
	
	public Tax getTributos() {
		return tributos;
	}
	
	private void setValorBruto (double valorTotalNotaFiscal) {
		valorBruto = valorTotalNotaFiscal;
	}

	public double getValorBruto() {
		return valorBruto;
	}
	
	private void setValorLiquido() {
		valorLiquido = getValorBruto() - getTributos().getValorTotalDescontos();
	}
	
	public double getValorLiquido() {
		return valorLiquido;
	}
}

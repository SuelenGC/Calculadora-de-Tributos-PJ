package br.com.suelengc.calctributospj.model;

public class NotaFiscal {

	private double valorBruto;
	private double valorLiquido;
	private Tributacao tributos;  
	
	public NotaFiscal(double valorTotalNotaFiscal, Tributacao tributos) {
		setValorBruto(valorTotalNotaFiscal);
		setTributos(tributos);
		setValorLiquido();		
	}

	public void setTributos(Tributacao tributo) {
		this.tributos = tributo;
	}
	
	public Tributacao getTributos() {
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

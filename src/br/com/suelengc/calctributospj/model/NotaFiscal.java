package br.com.suelengc.calctributospj.model;

public class NotaFiscal {

	private double valorBruto;
	private double valorLiquido;
	private Tributos tributos;  
	
	public NotaFiscal(double valorTotalNotaFiscal, Tributos tributos) {
		setValorBruto(valorTotalNotaFiscal);
		setTributos(tributos);
		setValorLiquido();		
	}

	public void setTributos(Tributos tributo) {
		this.tributos = tributo;
	}
	
	private void setValorBruto (double valorTotalNotaFiscal) {
		valorBruto = valorTotalNotaFiscal;
	}
	
	private void setValorLiquido() {
		valorLiquido = getValorBruto() - getTributos().getValorTotalDescontos();
	}
	
	public double getValorBruto() {
		return valorBruto;
	}

	public double getValorLiquido() {
		return valorLiquido;
	}
	
	public Tributos getTributos() {
		return tributos;
	}
}

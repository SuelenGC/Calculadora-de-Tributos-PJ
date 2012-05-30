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
	
	public Tributos getTributos() {
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

package br.com.suelengc.calctributospj.model;

import java.io.Serializable;

import br.com.suelengc.calctributospj.view.controller.Formatter;


public class NotaFiscal implements Serializable {

	private static final long serialVersionUID = 1L;
	private double valorBruto;
	private double valorLiquido;
	private Tributo tributo;  
	
	public NotaFiscal(double valorTotalNotaFiscal) {
		this.valorBruto = valorTotalNotaFiscal;
	}
	
	public NotaFiscal(double valorHora, double qtdeHora) {
		this(valorHora * qtdeHora);
	}

	public NotaFiscal(double valorTotalNotaFiscal, Tributo tributo) {
		this.valorBruto = valorTotalNotaFiscal;
		this.setTributos(tributo);
	}

	public void setTributos(Tributo tributo) {
		this.tributo = tributo;
	}
	
	public Tributo getTributo() {
		return tributo;
	}
	
	public double getValorBruto() {
		return valorBruto;
	}
	
	public double getValorLiquido() {
		return valorLiquido;
	}
	
	public void CalcularTributos() {
		tributo.Calcular(valorBruto);
		valorLiquido = valorBruto - tributo.getValorTotalTributos();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n\nResumo");
		builder.append("\nValor Bruto: R$ " + Formatter.DoubleToString(getValorBruto()));
		builder.append("\nTotal de Descontos: R$ " + Formatter.DoubleToString(tributo.getValorTotalTributos()));
		builder.append("\nValor Líquido: R$ " + Formatter.DoubleToString(getValorLiquido()));
		
		return tributo.toString() +  builder.toString();
	}
}

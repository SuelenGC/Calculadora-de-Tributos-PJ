package br.com.suelengc.calctributospj.model;

public class TributacaoNormal {
	private double irpjMensal;
	private double irpjTrimestral;
	private double cofinsMensal;
	private double pisMensal;
	private double csllMensal;
	private double csllTrimetral;
	private double issMensal;
	private double valorBrutoNotaFiscal;
	private double valorLiquidoNotaFiscal;
	private double valorTotalDescontosMensais;
	
	
	public TributacaoNormal(double valorTotalNotaFiscal) {
		this.valorBrutoNotaFiscal = valorTotalNotaFiscal;
		this.irpjMensal = valorTotalNotaFiscal * 0.015;
		this.irpjTrimestral = valorTotalNotaFiscal * 0.009;
		this.cofinsMensal = valorTotalNotaFiscal * 0.03;
		this.pisMensal = valorTotalNotaFiscal * 0.0065;
		this.csllMensal = valorTotalNotaFiscal * 0.01;
		this.csllTrimetral = valorTotalNotaFiscal * 0.0188;
		this.issMensal = valorTotalNotaFiscal * 0.02;
		this.valorLiquidoNotaFiscal = this.valorBrutoNotaFiscal - (this.irpjMensal + this.cofinsMensal + 
									this.pisMensal + this.csllMensal + this.issMensal); 
		this.valorTotalDescontosMensais = this.irpjMensal+this.cofinsMensal+this.csllMensal+this.pisMensal+this.issMensal;
	}

	public double getIrpjMensal() {
		return irpjMensal;
	}

	
	public double getIrpjTrimestral() {
		return irpjTrimestral;
	}

	
	public double getCofinsMensal() {
		return cofinsMensal;
	}

	
	public double getPisMensal() {
		return pisMensal;
	}

	
	public double getCsllMensal() {
		return csllMensal;
	}

	
	public double getCsllTrimetral() {
		return csllTrimetral;
	}

	
	public double getIssMensal() {
		return issMensal;
	}

	
	public double getValorTotalNotaFiscal() {
		return valorBrutoNotaFiscal;
	}	
	
	public double getValorBrutoNotaFiscal() {
		return valorBrutoNotaFiscal;
	}
	
	public double getValorLiquidoNotaFiscal() {
		return valorLiquidoNotaFiscal;
	}
	
	public double getTotalDescontosMensais() {
		return valorTotalDescontosMensais;
	}
}

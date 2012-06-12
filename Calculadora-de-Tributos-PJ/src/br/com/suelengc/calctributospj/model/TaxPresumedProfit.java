package br.com.suelengc.calctributospj.model;

public class TaxPresumedProfit implements Tax {
	private double irpjMensal;
	private double irpjTrimestral;
	private double cofinsMensal;
	private double pisMensal;
	private double csllMensal;
	private double csllTrimetral;
	private double issMensal;
	
	public TaxPresumedProfit(double valorTotalNotaFiscal, float percIRPJ) {
		setCofinsMensal(valorTotalNotaFiscal);
		setCsllMensal(valorTotalNotaFiscal);
		setCsllTrimetral(valorTotalNotaFiscal);
		setIrpjMensal(valorTotalNotaFiscal);
		setIrpjTrimestral(valorTotalNotaFiscal, percIRPJ);
		setIssMensal(valorTotalNotaFiscal);
		setPisMensal(valorTotalNotaFiscal);
	}

	private void setIrpjMensal(double valorTotalNotaFiscal) {
		this.irpjMensal = valorTotalNotaFiscal * 0.015;
	}

	private void setIrpjTrimestral(double valorTotalNotaFiscal, float percIRPJ) {
		if (percIRPJ == 2.4f) {
			this.irpjTrimestral = valorTotalNotaFiscal * 0.009;	
		} else if (percIRPJ == 4.8f) {
			this.irpjTrimestral = valorTotalNotaFiscal * 0.033;
		}
		
	}

	private void setCofinsMensal(double valorTotalNotaFiscal) {
		this.cofinsMensal = valorTotalNotaFiscal * 0.03;
	}

	private void setPisMensal(double valorTotalNotaFiscal) {
		this.pisMensal = valorTotalNotaFiscal * 0.0065;
	}

	private void setCsllMensal(double valorTotalNotaFiscal) {
		this.csllMensal = valorTotalNotaFiscal * 0.01;
	}

	private void setCsllTrimetral(double valorTotalNotaFiscal) {
		this.csllTrimetral = valorTotalNotaFiscal * 0.0188;
	}

	private void setIssMensal(double valorTotalNotaFiscal) {
		this.issMensal = valorTotalNotaFiscal * 0.02;
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

	public double getValorTotalDescontos() {
		return getCofinsMensal() + getCsllMensal() + getIrpjMensal() + getIssMensal() + getPisMensal();
	}
}

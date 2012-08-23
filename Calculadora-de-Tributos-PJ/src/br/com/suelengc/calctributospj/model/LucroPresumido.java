package br.com.suelengc.calctributospj.model;

import br.com.suelengc.calctributospj.domain.PercentualIRPJ;

public class LucroPresumido implements Tributo {
	private double irpjMensal;
	private double irpjTrimestral;
	private double cofinsMensal;
	private double pisMensal;
	private double csllMensal;
	private double csllTrimetral;
	private double issMensal;
	private PercentualIRPJ percentualIrpj;

	public LucroPresumido(PercentualIRPJ percentIRPJ) {
		percentualIrpj = percentIRPJ;
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

	@Override
	public double valorTotalTributos() {
		return irpjMensal + cofinsMensal + csllMensal + pisMensal + issMensal;
	}

	@Override
	public void Calcular(double valorBruto) {
		
		if (percentualIrpj.equals(PercentualIRPJ.DOIS_PONTO_QUATRO)) {
			this.irpjTrimestral = valorBruto * 0.009;	
		} else if (percentualIrpj.equals(PercentualIRPJ.QUATRO_PONTO_OITO)) {
			this.irpjTrimestral = valorBruto * 0.033;
		}
		
		this.irpjMensal= valorBruto * 0.015; 
		this.cofinsMensal = valorBruto * 0.03;
		this.pisMensal = valorBruto * 0.0065;
		this.csllMensal = valorBruto * 0.01;
		this.csllTrimetral = valorBruto * 0.0188;
		this.issMensal = valorBruto * 0.02;
	}
}

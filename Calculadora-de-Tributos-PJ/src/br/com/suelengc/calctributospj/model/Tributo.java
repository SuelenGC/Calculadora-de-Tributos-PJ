package br.com.suelengc.calctributospj.model;

import java.io.Serializable;


public interface Tributo extends Serializable {
	public double getValorTotalTributos();

	public void Calcular(double valorBruto); 
}

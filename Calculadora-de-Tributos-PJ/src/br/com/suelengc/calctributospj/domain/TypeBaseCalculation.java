package br.com.suelengc.calctributospj.domain;

public enum TypeBaseCalculation implements TypeBase {
	VALOR_HORA("Valor/Hora"), VALOR_BRUTO("Valor Bruto"); 
	
	private String descricao;
	
	private TypeBaseCalculation(String value) {
		this.descricao = value;
	}
	
	@Override
	public String toString() {
		return this.descricao;
	} 
}

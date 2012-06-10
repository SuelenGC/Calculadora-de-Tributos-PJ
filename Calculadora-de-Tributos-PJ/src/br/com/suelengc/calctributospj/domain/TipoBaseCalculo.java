package br.com.suelengc.calctributospj.domain;

public enum TipoBaseCalculo implements TipoBase {
	VALOR_HORA("Valor/Hora"), VALOR_BRUTO("Valor Bruto"); 
	
	String descricao;
	
	private TipoBaseCalculo(String value) {
		this.descricao = value;
	}
	
	public String ToString() {
		return this.descricao;
	} 
}

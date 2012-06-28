package br.com.suelengc.calctributospj.domain;

public enum TipoBaseCalculo {
	VALOR_HORA("Valor/Hora"), VALOR_BRUTO("Valor Bruto"); 
	
	private String descricao;
	
	private TipoBaseCalculo(String value) {
		this.descricao = value;
	}
	
	@Override
	public String toString() {
		return this.descricao;
	} 
}

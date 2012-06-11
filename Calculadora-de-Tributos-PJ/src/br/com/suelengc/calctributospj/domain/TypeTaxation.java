package br.com.suelengc.calctributospj.domain;

public enum TypeTaxation implements TypeBase {
	LUCRO_PRESUMIDO("Lucro Presumido"), SIMPLES_NACIONAL("Simples Nacional");
	
	String descricao;
	
	private TypeTaxation (String value) {
		this.descricao = value;
	}
	
	@Override
	public String toString () {
		return this.descricao;
	}

}

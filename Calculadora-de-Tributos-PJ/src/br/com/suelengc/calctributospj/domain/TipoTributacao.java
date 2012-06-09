package br.com.suelengc.calctributospj.domain;

public enum TipoTributacao implements TipoBase {
	LUCRO_PRESUMIDO("Lucro Presumido"), SIMPLES_NACIONAL("Simples Nacional");
	
	String descricao;
	
	private TipoTributacao (String value) {
		this.descricao = value;
	}
	
	@Override
	public String toString () {
		return this.descricao;
	}
}

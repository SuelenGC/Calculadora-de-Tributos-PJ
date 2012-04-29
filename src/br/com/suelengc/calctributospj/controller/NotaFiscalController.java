package br.com.suelengc.calctributospj.controller;

import br.com.suelengc.calctributospj.model.*;

public class NotaFiscalController {

	private NotaFiscal notaFiscal;
	
	public NotaFiscalController (double valorTotalNotaFiscal) {
		notaFiscal = new NotaFiscal(valorTotalNotaFiscal, new TributosLucroPresumido(valorTotalNotaFiscal));
	}
	
	public NotaFiscalController (double valorHora, double qtdeHoras) {
		this(valorHora * qtdeHoras);

	}
	
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	} 

}

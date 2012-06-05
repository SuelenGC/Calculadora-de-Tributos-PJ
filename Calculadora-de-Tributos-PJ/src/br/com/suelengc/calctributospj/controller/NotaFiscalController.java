package br.com.suelengc.calctributospj.controller;

import br.com.suelengc.calctributospj.model.*;

public class NotaFiscalController {

	private NotaFiscal notaFiscal;
	
	public NotaFiscalController (double valorTotalNotaFiscal, int tipoTributacao) {
		if (tipoTributacao == 1) {
			notaFiscal = new NotaFiscal(valorTotalNotaFiscal, new TributosLucroPresumido(valorTotalNotaFiscal));
		} else if (tipoTributacao ==2) {
			notaFiscal = new NotaFiscal(valorTotalNotaFiscal, new TributosSimples(valorTotalNotaFiscal));
		}
		
	}
	
	public NotaFiscalController (double valorHora, double qtdeHoras, int tipoTributacao) {
		this(valorHora * qtdeHoras, tipoTributacao);

	}
	
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	} 

}

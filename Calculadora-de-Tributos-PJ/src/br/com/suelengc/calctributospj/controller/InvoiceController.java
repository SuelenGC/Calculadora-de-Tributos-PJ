package br.com.suelengc.calctributospj.controller;

import br.com.suelengc.calctributospj.model.NotaFiscal;
import br.com.suelengc.calctributospj.model.TributacaoLucroPresumido;

public class InvoiceController {

	private NotaFiscal notaFiscal;
	
	public InvoiceController (double valorTotalNotaFiscal, int tipoTributacao, float percIRPJ) {
		notaFiscal = new NotaFiscal(valorTotalNotaFiscal, new TributacaoLucroPresumido(valorTotalNotaFiscal, percIRPJ));
	}
	
	public InvoiceController (double valorHora, double qtdeHoras, int tipoTributacao, float percIRPJ) {
		this(valorHora * qtdeHoras, tipoTributacao, percIRPJ);

	}
	
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	} 

}

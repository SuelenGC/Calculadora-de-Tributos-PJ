package br.com.suelengc.calctributospj.controller;

import br.com.suelengc.calctributospj.model.Invoice;
import br.com.suelengc.calctributospj.model.TaxPresumedProfit;

public class InvoiceController {

	private Invoice notaFiscal;
	
	public InvoiceController (double valorTotalNotaFiscal, int tipoTributacao, float percIRPJ) {
		notaFiscal = new Invoice(valorTotalNotaFiscal, new TaxPresumedProfit(valorTotalNotaFiscal, percIRPJ));
	}
	
	public InvoiceController (double valorHora, double qtdeHoras, int tipoTributacao, float percIRPJ) {
		this(valorHora * qtdeHoras, tipoTributacao, percIRPJ);

	}
	
	public Invoice getNotaFiscal() {
		return notaFiscal;
	} 

}

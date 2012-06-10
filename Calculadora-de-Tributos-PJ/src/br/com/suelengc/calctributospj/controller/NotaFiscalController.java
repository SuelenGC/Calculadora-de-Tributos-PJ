package br.com.suelengc.calctributospj.controller;

import android.content.Context;
import br.com.suelengc.calctributospj.model.*;
import br.com.suelengc.calctributospj.preference.*;

public class NotaFiscalController {

	private NotaFiscal notaFiscal;
	
	public NotaFiscalController (double valorTotalNotaFiscal, int tipoTributacao, float percIRPJ) {
		notaFiscal = new NotaFiscal(valorTotalNotaFiscal, new TributosLucroPresumido(valorTotalNotaFiscal, percIRPJ));
	}
	
	public NotaFiscalController (double valorHora, double qtdeHoras, int tipoTributacao, float percIRPJ) {
		this(valorHora * qtdeHoras, tipoTributacao, percIRPJ);

	}
	
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	} 

}

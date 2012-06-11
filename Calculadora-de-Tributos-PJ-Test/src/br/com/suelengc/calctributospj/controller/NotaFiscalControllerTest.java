package br.com.suelengc.calctributospj.controller;

import junit.framework.Assert;
import android.test.AndroidTestCase;

public class NotaFiscalControllerTest extends AndroidTestCase {

	public void testNotaFiscalAPartirDoValorBruto() {
		double valorBruto = 5000;
		
		InvoiceController notaFiscalController = new InvoiceController(valorBruto, 1, 2.4f);
		
		Assert.assertNotNull(notaFiscalController);
		Assert.assertEquals(notaFiscalController.getNotaFiscal().getValorBruto(), 5000.0);
	}
	
	public void testNotaFiscalAPartirDoValorPorHoraEQtdeDeHoras() {
		double valorPorHora = 55;
		double qtdeHoras = 168;
				
		InvoiceController notaFiscalController = new InvoiceController(valorPorHora, qtdeHoras, 1, 2.4f);
		
		Assert.assertNotNull(notaFiscalController);
		Assert.assertEquals(notaFiscalController.getNotaFiscal().getValorBruto(), 9240.0);
	}
	
}

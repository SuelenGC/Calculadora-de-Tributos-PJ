package br.com.suelengc.calctributospj.controller.test;

import junit.framework.Assert;
import android.test.AndroidTestCase;
import br.com.suelengc.calctributospj.controller.*;

public class NotaFiscalControllerTest extends AndroidTestCase {

	public void testNotaFiscalAPartirDoValorBruto() {
		double valorBruto = 5000;
		
		NotaFiscalController notaFiscalController = new NotaFiscalController(valorBruto, 1);
		
		Assert.assertNotNull(notaFiscalController);
		Assert.assertEquals(notaFiscalController.getNotaFiscal().getValorBruto(), 5000.0);
	}
	
	public void testNotaFiscalAPartirDoValorPorHoraEQtdeDeHoras() {
		double valorPorHora = 55;
		double qtdeHoras = 168;
				
		NotaFiscalController notaFiscalController = new NotaFiscalController(valorPorHora, qtdeHoras, 1);
		
		Assert.assertNotNull(notaFiscalController);
		Assert.assertEquals(notaFiscalController.getNotaFiscal().getValorBruto(), 9240.0);
	}
	
}

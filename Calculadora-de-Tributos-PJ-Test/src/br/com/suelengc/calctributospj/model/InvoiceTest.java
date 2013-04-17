package br.com.suelengc.calctributospj.model;

import br.com.suelengc.calctributospj.domain.PercentualIRPJ;
import android.test.AndroidTestCase;

public class InvoiceTest extends AndroidTestCase {

	public void testCreateANewInvoice() {
		//Defining gross value
		double grossValue = 6000;
		
		//Defining IRPJ percentage
		PercentualIRPJ percIRPJ = PercentualIRPJ.DOIS_PONTO_QUATRO;
		
		//Defining Taxation type
		Tributo tax = new LucroPresumido(percIRPJ, 3);
		
		//Create a new invoice
		NotaFiscal invoice = new NotaFiscal(grossValue, tax);
		
		//Checking invoice
		assertNotNull(invoice);
	}
	
	public void testGetGrossValue() {
		//Defining gross value
		double grossValue = 9000;
		
		//Defining taxation type
		Tributo tax = new SimplesNacional();
		
		//Create a new invoice
		NotaFiscal invoice = new NotaFiscal(grossValue, tax);
		
		//Check invoice gross value
		assertEquals(grossValue, invoice.getValorBruto());
	}

}

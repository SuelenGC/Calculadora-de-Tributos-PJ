package br.com.suelengc.calctributospj.model;

import android.test.AndroidTestCase;

public class InvoiceTest extends AndroidTestCase {

	public void testCreateANewInvoice() {
		//Defining gross value
		double grossValue = 6000;
		
		//Defining IRPJ percentage
		float percIRPJ = 2.4f;
		
		//Defining Taxation type
		Tributacao tax = new TributacaoLucroPresumido(grossValue, percIRPJ);
		
		//Create a new invoice
		NotaFiscal invoice = new NotaFiscal(grossValue, tax);
		
		//Checking invoice
		assertNotNull(invoice);
	}
	
	public void testGetGrossValue() {
		//Defining gross value
		double grossValue = 9000;
		
		//Defining taxation type
		Tributacao tax = new TributacaoSimples(grossValue);
		
		//Create a new invoice
		NotaFiscal invoice = new NotaFiscal(grossValue, tax);
		
		//Check invoice gross value
		assertEquals(grossValue, invoice.getValorBruto());
	}

}

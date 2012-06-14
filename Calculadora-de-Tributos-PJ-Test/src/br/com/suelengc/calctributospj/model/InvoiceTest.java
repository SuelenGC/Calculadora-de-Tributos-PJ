package br.com.suelengc.calctributospj.model;

import android.test.AndroidTestCase;

public class InvoiceTest extends AndroidTestCase {

	public void testCreateANewInvoice() {
		//Defining gross value
		double grossValue = 6000;
		
		//Defining IRPJ percentage
		float percIRPJ = 2.4f;
		
		//Defining Taxation type
		Tax tax = new TaxPresumedProfit(grossValue, percIRPJ);
		
		//Create a new invoice
		Invoice invoice = new Invoice(grossValue, tax);
		
		//Checking invoice
		assertNotNull(invoice);
	}
	
	public void testGetGrossValue() {
		//Defining gross value
		double grossValue = 9000;
		
		//Defining taxation type
		Tax tax = new TaxSimple(grossValue);
		
		//Create a new invoice
		Invoice invoice = new Invoice(grossValue, tax);
		
		//Check invoice gross value
		assertEquals(grossValue, invoice.getValorBruto());
	}

}

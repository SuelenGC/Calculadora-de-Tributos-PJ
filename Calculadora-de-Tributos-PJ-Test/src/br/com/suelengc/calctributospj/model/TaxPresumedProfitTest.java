package br.com.suelengc.calctributospj.model;

import java.lang.reflect.Constructor;

import android.test.AndroidTestCase;
import android.util.Log;

public class TaxPresumedProfitTest extends AndroidTestCase {
	
	@SuppressWarnings("unchecked")
	public void testContructors() throws Throwable {
		//Get class object 
		Class<TaxPresumedProfit> clazz = TaxPresumedProfit.class;
		
		//Get constructors 
		Constructor<TaxPresumedProfit>[] constructors = clazz.getConstructors();
		
		//Log how many constructors have
		Log.e("TEST_CT-PJ", "Number of contructors is " + constructors.length);
		
		//Checking if have some constructor without parameters
		for (Constructor<TaxPresumedProfit> c : constructors) {
			
			//Get parameters type
			Class<?>[] parameters = c.getParameterTypes();
			
			//Log how many parameters have
			Log.e("TEST_CT-PJ", "Contructor with " + parameters.length + " parameters");
			
			//Validating if have more than zero parameters
			assertTrue(parameters.length>0);
		}
	}
	
	public void testCofinsValue() {
		//Defining gross value
		double grossValue = 6000;
		
		//Defining IRPJ percentage
		float percIRPJ = 2.4f;
		
		//Defining Taxation type
		Tax tax = new TaxPresumedProfit(grossValue, percIRPJ);
		
		//Create a new invoice
		Invoice invoice = new Invoice(grossValue, tax);
	}
}

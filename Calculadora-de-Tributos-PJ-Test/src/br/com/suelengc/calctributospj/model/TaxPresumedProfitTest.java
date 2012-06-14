package br.com.suelengc.calctributospj.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import android.test.AndroidTestCase;
import android.util.Log;

public class TaxPresumedProfitTest extends AndroidTestCase {
	
	@SuppressWarnings("unchecked")
	public void testContructorsWithoutParameters() throws Throwable {
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
		double grossValue = 5000;
		
		//Defining IRPJ percentage
		float percIRPJ = 2.4f;
		
		//Creating taxation object
		Tax tax = new TaxPresumedProfit(grossValue, percIRPJ);

		//Checking the cofins value
		assertEquals( ((TaxPresumedProfit) tax).getCofinsMensal(), 150.0);
	}
	
	public void testCsllMonthlyValue() {
		//Defining gross value
		double grossValue = 5000;
		
		//Defining IRPJ percentage
		float percIRPJ = 2.4f;
		
		//Creating taxation object
		Tax tax = new TaxPresumedProfit(grossValue, percIRPJ);

		//Checking the monthly csll value
		assertEquals( ((TaxPresumedProfit) tax).getCsllMensal(), 50.0);
	}

	public void testCsllQuarterlyValue() {
		//Defining gross value
		double grossValue = 5000;
		
		//Defining IRPJ percentage
		float percIRPJ = 2.4f;
		
		//Creating taxation object
		Tax tax = new TaxPresumedProfit(grossValue, percIRPJ);

		//Checking the quarterly csll value
		assertEquals( ((TaxPresumedProfit) tax).getCsllTrimetral(), 94.0);
	}
	
	public void testIrpjMonthlyValue() {
		//Defining gross value
		double grossValue = 5000;
		
		//Defining IRPJ percentage
		float percIRPJ = 2.4f;
		
		//Creating taxation object
		Tax tax = new TaxPresumedProfit(grossValue, percIRPJ);

		//Checking the monthly irpj value
		assertEquals( ((TaxPresumedProfit) tax).getIrpjMensal(), 75.0);
	}

	
	public void testIrpjQuarterlyValueWithTwoDotFourIrpjPercentage() {
		//Defining gross value
		double grossValue = 5000;
		
		//Defining IRPJ percentage
		float percIRPJ = 2.4f;
		
		//Creating taxation object
		Tax tax = new TaxPresumedProfit(grossValue, percIRPJ);

		//Checking the quarterly irpj value
		assertEquals( ((TaxPresumedProfit) tax).getIrpjTrimestral(), 45.0);
	}

	public void testIrpjQuarterlyValueWithFourDotEightIrpjPercentage() {
		//Defining gross value
		double grossValue = 5000;
		
		//Defining IRPJ percentage
		float percIRPJ = 4.8f;
		
		//Creating taxation object
		Tax tax = new TaxPresumedProfit(grossValue, percIRPJ);

		//Checking the quarterly irpj value
		assertEquals( ((TaxPresumedProfit) tax).getIrpjTrimestral(), 165.0);
	}

	public void testPisValue() {
		//Defining gross value
		double grossValue = 5000;
		
		//Defining IRPJ percentage
		float percIRPJ = 2.4f;
		
		//Creating taxation object
		Tax tax = new TaxPresumedProfit(grossValue, percIRPJ);

		//Checking the monthly irpj value
		assertEquals( ((TaxPresumedProfit) tax).getPisMensal(), 32.5);
	}
	
	public void testIssValue() {
		//Defining gross value
		double grossValue = 5000;
		
		//Defining IRPJ percentage
		float percIRPJ = 2.4f;
		
		//Creating taxation object
		Tax tax = new TaxPresumedProfit(grossValue, percIRPJ);

		//Checking the monthly irpj value
		assertEquals( ((TaxPresumedProfit) tax).getIssMensal(), 100.0);
	}
	
	public void testGetTotalDiscountValue() {
		//Defining gross value
		double grossValue = 5000;
		
		//Defining IRPJ percentage
		float percIRPJ = 2.4f;
		
		//Creating taxation object
		Tax tax = new TaxPresumedProfit(grossValue, percIRPJ);

		//Checking the monthly irpj value
		assertEquals( ((TaxPresumedProfit) tax).getValorTotalDescontos(), 407.5);
	}
	
	public void testSetters() {
		//Get class object
		Class<TaxPresumedProfit> clazz = TaxPresumedProfit.class;
		
		//Get methods
		Method[] methods = clazz.getDeclaredMethods();
		
		//Create a array of privates methods
		ArrayList<Method> methodsPrivate = new ArrayList<Method>();
		
		//Feeding the methodsPrivate whit setters methods
		for (Method m : methods) {
			if (m.getName().substring(0, 3).equals("set")) {
				methodsPrivate.add(m);
			}
		}
		
		//Checking if modifiers of setters are only private
		for (Method m : methodsPrivate) {
			Log.e("TEST_CT-PJ", "Method " + m.getName() + " have the modifier " + m.getModifiers());
			assertEquals(Modifier.PRIVATE, m.getModifiers());
		}
	}
}

package br.com.suelengc.calctributospj.model;

import java.lang.reflect.Constructor;

import android.test.AndroidTestCase;
import android.util.Log;

public class TaxPresumedProfitTest extends AndroidTestCase {
	
	@SuppressWarnings("unchecked")
	public void testContructors() throws Throwable {
		Class<TaxPresumedProfit> clazz = TaxPresumedProfit.class;
		Constructor<TaxPresumedProfit>[] constructors = clazz.getConstructors();
		
		Log.e("TEST_CT-PJ", "Number of contructors is " + constructors.length);
		
		for (Constructor<TaxPresumedProfit> c : constructors) {
			Class<?>[] parameters = c.getParameterTypes();
			
			Log.e("TEST_CT-PJ", "Contructor with " + parameters.length + " parameters");
			
			assertTrue(parameters.length>0);
		}
	}
}

package br.com.suelengc.calctributospj.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.TypeVariable;

import android.test.AndroidTestCase;
import android.util.Log;

public class TaxPresumedProfitTest extends AndroidTestCase {
	
	@SuppressWarnings("unchecked")
	public void testContructors() throws Throwable {
		Class<TaxPresumedProfit> clazz = TaxPresumedProfit.class;
		Constructor<TaxPresumedProfit>[] constructors = clazz.getConstructors();
		
		for (Constructor<TaxPresumedProfit> c : constructors) {
			//Class<?>[] parameters = c.getParameterTypes();
			TypeVariable<?>[] parameters = c.getTypeParameters();
			
			Log.d("TEST_CT-PJ", "Contructor with " + parameters.length + " parameters");
			
			assertTrue(parameters.length>0);
		}
	}
}

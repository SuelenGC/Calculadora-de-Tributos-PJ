package br.com.suelengc.calctributospj.model;

import java.lang.reflect.Constructor;

import android.test.AndroidTestCase;
import android.util.Log;

public class TaxSimpleTest extends AndroidTestCase {

		@SuppressWarnings("unchecked")
		public void testContructors() throws Throwable {
			//Get class object 
			Class<TributoLucroPresumido> clazz = TributoLucroPresumido.class;
			
			//Get constructors 
			Constructor<SimplesNacional>[] constructors = clazz.getConstructors();
			
			//Log how many constructors have
			Log.e("TEST_CT-PJ", "Number of contructors is " + constructors.length);
			
			//Checking if have some constructor without parameters
			for (Constructor<SimplesNacional> c : constructors) {
				
				//Get parameters type
				Class<?>[] parameters = c.getParameterTypes();
				
				//Log how many parameters have
				Log.e("TEST_CT-PJ", "Contructor with " + parameters.length + " parameters");
				
				//Validating if have more than zero parameters
				assertTrue(parameters.length>0);
			}
		}

	
}

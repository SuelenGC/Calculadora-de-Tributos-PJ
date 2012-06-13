package br.com.suelengc.calctributospj.domain;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import android.test.AndroidTestCase;
import android.util.Log;

public class TipoBaseCalculoTest extends AndroidTestCase {

	public void testFields() {

		Class<TypeBaseCalculation> clazz = TypeBaseCalculation.class;

		Field[] fields = clazz.getDeclaredFields();
		try {
			Field descricao = clazz.getDeclaredField("descricao");
			assertEquals(Modifier.PRIVATE, descricao.getModifiers());
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}

		Log.e("SIZE:", Integer.toString(fields.length));
		
		for (int i = 0; i < fields.length; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(Modifier.toString(fields[i].getModifiers()));
			sb.append(" ");
			sb.append(fields[i].getType().getName().toString());
			sb.append(" ");
			sb.append(fields[i].getName().toString());
			
			Log.e("TEST_CT-PJ", sb.toString());
			
		}

	}

}

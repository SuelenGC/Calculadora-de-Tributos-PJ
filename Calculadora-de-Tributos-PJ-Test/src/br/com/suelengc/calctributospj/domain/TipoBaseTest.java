package br.com.suelengc.calctributospj.domain;

import android.test.AndroidTestCase;

public class TipoBaseTest extends AndroidTestCase {

	public void testToString() {
		TypeBase base = TypeBaseCalculation.VALOR_BRUTO;
		TypeBaseCalculation bruto = TypeBaseCalculation.VALOR_BRUTO;
	
		assertEquals("Valor Bruto", base.toString());
		assertEquals(base.toString(), bruto.toString());
	}
}

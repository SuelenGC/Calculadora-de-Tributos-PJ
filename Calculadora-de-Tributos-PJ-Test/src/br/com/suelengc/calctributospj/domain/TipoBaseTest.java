package br.com.suelengc.calctributospj.domain;

import br.com.suelengc.calctributospj.domain.TipoBaseCalculo;
import android.test.AndroidTestCase;

public class TipoBaseTest extends AndroidTestCase {

	public void testToString() {
		TipoBase base = TipoBaseCalculo.VALOR_BRUTO;
		TipoBaseCalculo bruto = TipoBaseCalculo.VALOR_BRUTO;
	
		assertEquals("Valor Bruto", base.toString());
		assertEquals(base.toString(), bruto.toString());
	}
}

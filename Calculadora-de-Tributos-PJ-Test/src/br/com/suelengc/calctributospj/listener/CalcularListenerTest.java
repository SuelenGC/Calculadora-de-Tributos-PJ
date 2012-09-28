package br.com.suelengc.calctributospj.listener;

import org.junit.Test;

import br.com.suelengc.calctributospj.domain.TipoBaseCalculo;
import br.com.suelengc.calctributospj.preference.PreferenciasCalculo;
import br.com.suelengc.calctributospj.view.listener.CalcularListener;
import android.test.AndroidTestCase;

public class CalcularListenerTest extends AndroidTestCase {

	@Test
	public void testCalcularAPartirDoValorHora() {
		double valorHora = 50;
		int qtdeHoras = 168;
		TipoBaseCalculo baseCalculo = TipoBaseCalculo.VALOR_HORA;
		PreferenciasCalculo preferenciasDeCalculo = new PreferenciasCalculo(getContext());
		
		CalcularListener listener = new CalcularListener(preferenciasDeCalculo, baseCalculo);
		
	} 
	
}

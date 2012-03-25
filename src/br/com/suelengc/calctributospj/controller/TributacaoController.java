package br.com.suelengc.calctributospj.controller;

import java.text.NumberFormat;
import java.util.Locale;
import br.com.suelengc.calctributospj.model.*;

public class TributacaoController {

	public TributacaoNormal CalculaTributos(double valorhora, double totalhoras) {
		
		double valorTotalNF = valorhora * totalhoras;
		TributacaoNormal objTributacaoNormal = new TributacaoNormal(valorTotalNF);
		return objTributacaoNormal;

	}
}

package br.com.suelengc.calctributospj.view.controller;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Formatter {
	public static String DoubleToString(double valor) {
		NumberFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
		return df.format(valor);
	}

	public String commaToDot(String value) {
		return value.replace(",", "."); 
	}

}

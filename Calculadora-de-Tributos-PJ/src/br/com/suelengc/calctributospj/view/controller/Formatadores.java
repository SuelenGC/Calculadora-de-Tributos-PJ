package br.com.suelengc.calctributospj.view.controller;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Formatadores {
	public static String DoubleToString(double valor) {
		NumberFormat df = new DecimalFormat("#,###.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
		return df.format(valor);
	}
}

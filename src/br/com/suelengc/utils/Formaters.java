package br.com.suelengc.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Formaters {
	public static String DoubleToString(double valor) {
		NumberFormat df = new DecimalFormat("#,###.00");
		return df.format(valor);
	}
}

package br.com.suelengc.calctributospj.preference;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencias {
	private static final String PREF_FILE_CTPJ = "PREFERENCIAS_CTPJ";
	private SharedPreferences preferencias;
	private SharedPreferences.Editor editor;
	
	public Preferencias(Context context) {
		preferencias = context.getSharedPreferences(PREF_FILE_CTPJ, Context.MODE_PRIVATE);
		editor = preferencias.edit();
	}
	
	// get-set int
	public int getInt(String item) {
    	return preferencias.getInt(item, 0);
	}
	
	public void setInt(String item, int valor) {
        editor.putInt(item, valor);
        editor.commit();
	}

	// get-set float
	public float getFloat(String item) {
    	return preferencias.getFloat(item, 0.0f);
	}
	
	public void setFloat(String item, float valor) {
        editor.putFloat(item, valor);
        editor.commit();
	}
	
	// get-set string
	public String getString(String item) {
    	return preferencias.getString(item, null);
	}
	
	public void setString(String item, String valor) {
        editor.putString(item, valor);
        editor.commit();
	}
	
	// get-set long
	public long getLong(String item) {
    	return preferencias.getLong(item, 0);
	}
	
	public void setLong(String item, long valor) {
        editor.putLong(item, valor);
        editor.commit();
	}
	
	// get-set boolean
	public boolean getBoolean(String item) {
    	return preferencias.getBoolean(item, false);
	}
	
	public void setBoolean(String item, boolean valor) {
        editor.putBoolean(item, valor);
        editor.commit();
	}
}
package br.com.suelengc.calctributospj.preference;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
	public static final String PREF_FILE_CTPJ = "PREFERENCES_CTPJ";
	
    public static int getPreferenciaValorInteiro(Context c, String item) {
    	SharedPreferences settings = c.getSharedPreferences(PREF_FILE_CTPJ, Context.MODE_PRIVATE);
        int tipoTributacao = settings.getInt(item, 1);
        return tipoTributacao;
	}

    public static int getPreferenciaObjeto(Context c, String item) {
    	SharedPreferences settings = c.getSharedPreferences(PREF_FILE_CTPJ, Context.MODE_PRIVATE);
        int tipoTributacao = settings.getInt(item, 1);
        return tipoTributacao;
	}
    
    public static float getPreferenciaValorFloat(Context c, String item) {
    	SharedPreferences settings = c.getSharedPreferences(PREF_FILE_CTPJ, Context.MODE_PRIVATE);
        float tipoTributacao = settings.getFloat(item, 2.4f);
        return tipoTributacao;
	}
    
    public static void setPreferencia(Context c, String item, int valorConfiguracao) {
    	SharedPreferences settings = c.getSharedPreferences(PREF_FILE_CTPJ, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(item, valorConfiguracao);
        editor.commit();
    }
    
    public static void setPreferencia(Context c, String item, float valorConfiguracao) {
    	SharedPreferences settings = c.getSharedPreferences(PREF_FILE_CTPJ, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putFloat(item, valorConfiguracao);
        editor.commit();
    }
}


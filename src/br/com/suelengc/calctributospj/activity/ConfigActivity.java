package br.com.suelengc.calctributospj.activity;

import android.app.Activity;
import android.os.Bundle;
import br.com.suelengc.calctributospj.R;

public class ConfigActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);
        setTitle("Calculadora de Tributos PJ - Configurações");
    }

}
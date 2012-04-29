package br.com.suelengc.calctributospj.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import br.com.suelengc.calctributospj.R;

public class MenuActivity extends Activity {

	public static final String EXTRA_FORMATO_TELA = "1"; 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		setTitle("Calculadora de Tributos PJ - Menu");
		
		Toast.makeText(MenuActivity.this, "Tipo Tributação: " + getTipoTributacao(), Toast.LENGTH_SHORT).show();
	}
	
	public void CallCalcActivity_ByValuePerHour(View view) {
		Intent intent = new Intent(this, CalcActivity.class);
		intent.putExtra(EXTRA_FORMATO_TELA, "1");
		startActivity(intent);
		
	}
	
	public void CallCalcActivity_ByValue(View view) {
		Intent intent = new Intent(this, CalcActivity.class);
		intent.putExtra(EXTRA_FORMATO_TELA, "2");
		startActivity(intent);
	}
	
	private String getTipoTributacao() {
		SharedPreferences settings = getSharedPreferences("TIPO_TRIBUTACAO", MODE_PRIVATE);
        int tipoTributacao = settings.getInt("TipoTributacao", 1);
        if (tipoTributacao == 1) 
        	return "Lucro Presumido";
        else 
        	return "Simples";
	}
	
}

package br.com.suelengc.calctributospj.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.util.Preferencias;

public class MenuActivity extends Activity {

	public static final String EXTRA_FORMATO_TELA = "1"; 
	private static final int SOBRE = Menu.FIRST;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		setTitle("Calculadora de Tributos PJ - Menu");
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
	
	public void CallInfoActivity(View view) {
		Intent intent = new Intent(this, SobreActivity.class);
		startActivity(intent);
	}
	
	public void CallConfigActivity(View view) {
		Intent intent = new Intent(this, ConfigActivity.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, SOBRE, 0, "Sobre!");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case SOBRE:
			Intent intent = new Intent(this, SobreActivity.class);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}

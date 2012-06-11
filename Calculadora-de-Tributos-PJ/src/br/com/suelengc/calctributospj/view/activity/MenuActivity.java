package br.com.suelengc.calctributospj.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.domain.TypeBaseCalculation;

public class MenuActivity extends Activity {

	public static final String EXTRA_FORMATO_TELA = "1"; 
	private static final int SETTINGS = Menu.FIRST;
	private static final int SOBRE = Menu.FIRST+1;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		setTitle("Calculadora de Tributos PJ - Menu");
	}
	
	public void CallCalcActivity_ByValuePerHour(View view) {
		Intent intent = new Intent(this, CalculationActivity.class);
		intent.putExtra(EXTRA_FORMATO_TELA, TypeBaseCalculation.VALOR_HORA);
		startActivity(intent);
		
	}
	
	public void CallCalcActivity_ByValue(View view) {
		Intent intent = new Intent(this, CalculationActivity.class);
		intent.putExtra(EXTRA_FORMATO_TELA, TypeBaseCalculation.VALOR_BRUTO);
		startActivity(intent);
	}
	
	public void CallInfoActivity(View view) {
		Intent intent = new Intent(this, InformationActivity.class);
		startActivity(intent);
	}
	
	public void CallConfigActivity(View view) {
		Intent intent = new Intent(this, ConfigurationActivity.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		Log.d("SuelenGC", menu.toString());
		MenuInflater mi = new MenuInflater(getApplicationContext());
		mi.inflate(R.menu.menu, menu);
		
		return true;
		//menu.add(0, SOBRE, 0, "Sobre!");
		//return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//Intent intent = new Intent(this, SettingsActivity.class);
		//startActivity(intent);
		
		Intent intent;
		
		Log.d("SuelenGC", "Menu: " + item.getItemId());

		switch (item.getOrder()) {
		
		case SOBRE:
			intent = new Intent(this, InformationActivity.class);
			startActivity(intent);
			return true;
			
		case SETTINGS:
			intent = new Intent(this, SettingsActivity.class);
			startActivity(intent);
			return true;
			
		default:
			return super.onOptionsItemSelected(item);
		}
		
	}
}

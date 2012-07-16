package br.com.suelengc.calctributospj.view.activity;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

import android.content.Intent;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.domain.TipoBaseCalculo;

public class MenuActivity extends SherlockActivity{

	public static final String EXTRA_FORMATO_TELA = "1"; 
	private static final int SETTINGS = Menu.FIRST;
	private static final int SOBRE = Menu.FIRST+1;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		setTitle("Menu");
		
		GradientDrawable bg = (GradientDrawable) getResources().getDrawable(R.drawable.bg_gradient);
        getSupportActionBar().setBackgroundDrawable(bg);
	}
	
	public void CallCalcActivity_ByValuePerHour(View view) {
		Intent intent = new Intent(this, CalculationActivity.class);
		intent.putExtra(EXTRA_FORMATO_TELA, TipoBaseCalculo.VALOR_HORA);
		startActivity(intent);
		
	}
	
	public void CallCalcActivity_ByValue(View view) {
		Intent intent = new Intent(this, CalculationActivity.class);
		intent.putExtra(EXTRA_FORMATO_TELA, TipoBaseCalculo.VALOR_BRUTO);
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

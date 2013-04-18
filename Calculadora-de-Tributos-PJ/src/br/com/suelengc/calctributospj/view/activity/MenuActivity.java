package br.com.suelengc.calctributospj.view.activity;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.domain.TipoBaseCalculo;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;

public class MenuActivity extends BaseActivity {

	public static final String EXTRA_FORMATO_TELA = "1"; 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		setTitle("Menu");
		
		GradientDrawable bg = (GradientDrawable) getResources().getDrawable(R.drawable.bg_gradient);
        getSupportActionBar().setBackgroundDrawable(bg);
        
	}
	
	public void CallCalcActivity_ByValuePerHour(View view) {
		Intent intent = new Intent(this, CalculatorActivity.class);
		intent.putExtra(EXTRA_FORMATO_TELA, TipoBaseCalculo.VALOR_HORA);
		startActivity(intent);
		
	}
	
	public void CallCalcActivity_ByValue(View view) {
		Intent intent = new Intent(this, CalculatorActivity.class);
		intent.putExtra(EXTRA_FORMATO_TELA, TipoBaseCalculo.VALOR_BRUTO);
		startActivity(intent);
	}
	
	public void CallInfoActivity(View view) {
		Intent intent = new Intent(this, AboutActivity.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuInflater mi = new MenuInflater(getApplicationContext());
		mi.inflate(R.menu.menu, menu);
		
		return true;
	}
	
}

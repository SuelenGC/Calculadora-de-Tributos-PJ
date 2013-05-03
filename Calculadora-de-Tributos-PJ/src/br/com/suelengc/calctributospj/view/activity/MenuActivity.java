package br.com.suelengc.calctributospj.view.activity;

import android.R.bool;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.domain.TipoBaseCalculo;
import br.com.suelengc.calctributospj.preference.Preferencias;
import br.com.suelengc.calctributospj.view.menu.MyMenu;

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

		// Mostrar novidades
		Preferencias p = new Preferencias(this);
		boolean userAlreadyViewNews = p.getBoolean("view_news");
		if (userAlreadyViewNews == false) {
			NewsDialogFragment newFeaturesDialogFragment = new NewsDialogFragment();
			newFeaturesDialogFragment.show(getSupportFragmentManager(), "dialog");
		}
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

	public void CallCalcActivity_Donate(View view) {
		Intent intent = new Intent(this, DonateActivity.class);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater mi = new MenuInflater(getApplicationContext());
		mi.inflate(R.menu.menu, menu);

		menu.findItem(MyMenu.EMAIL).setVisible(false);
		menu.findItem(MyMenu.COPY).setVisible(false);
		menu.findItem(MyMenu.ABOUT).setVisible(false);

		return true;
	}

}

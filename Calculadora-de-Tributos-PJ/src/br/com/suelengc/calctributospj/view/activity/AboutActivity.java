package br.com.suelengc.calctributospj.view.activity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.view.menu.MyMenu;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;

public class AboutActivity extends BaseActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Sobre");
		setContentView(R.layout.about);

		GradientDrawable bg = (GradientDrawable) getResources().getDrawable(R.drawable.bg_gradient);
		getSupportActionBar().setBackgroundDrawable(bg);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater mi = new MenuInflater(getApplicationContext());
		mi.inflate(R.menu.menu, menu);

		/** Ocultar menus desta tela */
		menu.findItem(MyMenu.ABOUT).setVisible(false);
		menu.findItem(MyMenu.SETTINGS).setVisible(false);

		return true;
	}

}

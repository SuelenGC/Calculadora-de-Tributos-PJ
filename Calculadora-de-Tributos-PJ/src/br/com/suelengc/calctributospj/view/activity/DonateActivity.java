package br.com.suelengc.calctributospj.view.activity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.view.menu.MyMenu;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;

public class DonateActivity extends BaseActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.donate);
		
		GradientDrawable bg = (GradientDrawable) getResources().getDrawable(R.drawable.bg_gradient);
		getSupportActionBar().setBackgroundDrawable(bg);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		setTitle("Doação");
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		MenuInflater mi = new MenuInflater(getApplicationContext());
		mi.inflate(R.menu.menu, menu);
		
		/** Ocultar menus desta tela */
		menu.findItem(MyMenu.SETTINGS).setVisible(false);
		menu.findItem(MyMenu.COPY).setVisible(false);
		menu.findItem(MyMenu.ABOUT).setVisible(false);
		
		return true;
	}
}

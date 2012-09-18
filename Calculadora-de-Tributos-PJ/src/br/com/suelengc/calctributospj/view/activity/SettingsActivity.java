package br.com.suelengc.calctributospj.view.activity;

import android.app.Dialog;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.view.menu.MyMenu;

import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.actionbarsherlock.view.MenuItem;

public class SettingsActivity extends SherlockPreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Configurações");
		
		GradientDrawable bg = (GradientDrawable) getResources().getDrawable(R.drawable.bg_gradient);
        getSupportActionBar().setBackgroundDrawable(bg);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        PreferenceManager pm = getPreferenceManager();
        pm.setSharedPreferencesName("PREFERENCIAS_CTPJ"); 
        pm.setSharedPreferencesMode(this.MODE_PRIVATE);
        
        addPreferencesFromResource(R.xml.settings);		
        
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == MyMenu.HOME) {
			finish();
		}
		
		return super.onOptionsItemSelected(item);
		
	}
}

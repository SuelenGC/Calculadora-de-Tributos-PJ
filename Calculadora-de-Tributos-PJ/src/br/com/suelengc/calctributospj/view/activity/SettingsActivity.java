package br.com.suelengc.calctributospj.view.activity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import br.com.suelengc.calctributospj.R;

import com.actionbarsherlock.app.SherlockPreferenceActivity;

public class SettingsActivity extends SherlockPreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Configurações");
		
		GradientDrawable bg = (GradientDrawable) getResources().getDrawable(R.drawable.bg_gradient);
        getSupportActionBar().setBackgroundDrawable(bg);
        
        addPreferencesFromResource(R.xml.settings);		
	}
}

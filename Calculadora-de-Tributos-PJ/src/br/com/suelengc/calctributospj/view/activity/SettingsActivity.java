package br.com.suelengc.calctributospj.view.activity;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import br.com.suelengc.calctributospj.R;

public class SettingsActivity extends PreferenceActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		addPreferencesFromResource(R.xml.settings);
		
	}
}

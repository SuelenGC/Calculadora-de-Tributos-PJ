package br.com.suelengc.calctributospj.view.activity;

import android.content.Intent;
import br.com.suelengc.calctributospj.view.menu.MyMenu;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;

public class BaseActivity extends SherlockFragmentActivity {
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent;
		
		switch (item.getItemId()) {
		case MyMenu.HOME:
			finish();
			break;
			
		case MyMenu.ABOUT:
			intent = new Intent(this, AboutActivity.class);
			startActivity(intent);
			return true;
			
		case MyMenu.SETTINGS:
			intent = new Intent(this, SettingsActivity.class);
			startActivity(intent);
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}

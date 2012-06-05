package br.com.suelengc.calctributospj.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.utils.Preferencias;

public class MenuActivity extends Activity {

	public static final String EXTRA_FORMATO_TELA = "1"; 
	private static final int CONFIGURACOES = Menu.FIRST;
	private static final int INFORMACOES = Menu.FIRST+1;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		setTitle("Calculadora de Tributos PJ - Menu");
	}
	
	public void CallCalcActivity_ByValuePerHour(View view) {
		Intent intent = new Intent(this, CalcActivity.class);
		intent.putExtra(EXTRA_FORMATO_TELA, "1");
		startActivity(intent);
		
	}
	
	public void CallCalcActivity_ByValue(View view) {
		Intent intent = new Intent(this, CalcActivity.class);
		intent.putExtra(EXTRA_FORMATO_TELA, "2");
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, CONFIGURACOES, 0, "Configurações");
		menu.add(0, INFORMACOES, 0, "Informações");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case INFORMACOES:
			AlertDialog.Builder infos = new AlertDialog.Builder(MenuActivity.this);
			infos.setTitle("Desenvolvedor");
			infos.setMessage("Suelen G. Carvalho \n" +
							 "www.suelengc.com.br \n" +
							 "suelengcarvalho@gmail.com \n" +
							 "Versão 2.1");
			infos.setNeutralButton("Fechar", null);
			infos.show();
			
			return true;
		case CONFIGURACOES:
			startActivity(new Intent(this, ConfigActivity.class));
						
			return true;
			
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}

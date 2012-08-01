package br.com.suelengc.calctributospj.view.activity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import br.com.suelengc.calctributospj.R;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class CalculadoraActivity extends SherlockFragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);

        setTitle("Calculo valor/hora");
        
        GradientDrawable bg = (GradientDrawable) getResources().getDrawable(R.drawable.bg_gradient);
        getSupportActionBar().setBackgroundDrawable(bg);
	}
}
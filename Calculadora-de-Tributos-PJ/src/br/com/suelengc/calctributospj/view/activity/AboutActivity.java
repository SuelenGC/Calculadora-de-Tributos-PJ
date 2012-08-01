package br.com.suelengc.calctributospj.view.activity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import br.com.suelengc.calctributospj.R;

import com.actionbarsherlock.app.SherlockActivity;

public class AboutActivity extends SherlockActivity{
		    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setTitle("Sobre");
	        setContentView(R.layout.about);
	        
	        GradientDrawable bg = (GradientDrawable) getResources().getDrawable(R.drawable.bg_gradient);
	        getSupportActionBar().setBackgroundDrawable(bg);
	        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	    }
	
}

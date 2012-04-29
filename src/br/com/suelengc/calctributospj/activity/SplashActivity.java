package br.com.suelengc.calctributospj.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import br.com.suelengc.calctributospj.R;

public class SplashActivity extends Activity implements Runnable {
	    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);
        
        Handler h = new Handler();
        h.postDelayed(this, 3000);
        }

        public void run(){
        	startActivity(new Intent(this, MenuActivity.class));
        	finish();
        }

}
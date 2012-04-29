package br.com.suelengc.calctributospj.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import br.com.suelengc.calctributospj.R;

public class ConfigActivity extends Activity {
	
	RadioButton rbLucroPresumido, rbSimples;
	RadioGroup rgTipoTributacao;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);
        setTitle("Calculadora de Tributos PJ - Configurações");
        
        rgTipoTributacao = (RadioGroup) findViewById(R.id_config.rgTipoTributacao);
        rbLucroPresumido = (RadioButton) findViewById(R.id_config.rbLucroPresumido);
        rbSimples = (RadioButton) findViewById(R.id_config.rbSimples);
        
        rgTipoTributacao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(rbLucroPresumido.getId() == checkedId) {  
					Toast.makeText(ConfigActivity.this, "Lucro presumido selecionado!", Toast.LENGTH_SHORT).show();
					setPreference(1);
					
			    } else if(rbSimples.getId() == checkedId) {  
			    	Toast.makeText(ConfigActivity.this, "Simples selecionado!", Toast.LENGTH_SHORT).show();
			    	setPreference(2);
			    }  
			}
		});
    }
    
    private void setPreference(int tipoTributacao) {
    	SharedPreferences settings = getSharedPreferences("TIPO_TRIBUTACAO", MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("TipoTributacao", tipoTributacao);
        editor.commit();
    }

    
}
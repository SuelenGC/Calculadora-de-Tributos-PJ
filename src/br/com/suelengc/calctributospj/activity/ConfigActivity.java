package br.com.suelengc.calctributospj.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.utils.Preferencias;

public class ConfigActivity extends Activity {
	
	RadioButton rbLucroPresumido, rbSimples;
	RadioGroup rgTipoTributacao;
	LinearLayout frmPercIRPJ;
	TableLayout frmLucroPresumido, frmSimplesNacional;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);
        setTitle("Calculadora de Tributos PJ - Configurações");
        
        rgTipoTributacao = (RadioGroup) findViewById(R.id_config.rgTipoTributacao);
        rbLucroPresumido = (RadioButton) findViewById(R.id_config.rbLucroPresumido);
        rbSimples = (RadioButton) findViewById(R.id_config.rbSimples);
        
        if (Preferencias.getPreferenciaValor(ConfigActivity.this, "TipoTributacao") == 1) {
        	rbLucroPresumido.setChecked(true);
        	FormataTela(1);
        } else {
        	rbSimples.setChecked(true);
        	FormataTela(2);
        }
        
        rgTipoTributacao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(rbLucroPresumido.getId() == checkedId) {  
					Toast.makeText(ConfigActivity.this, "Lucro Presumido selecionado!", Toast.LENGTH_SHORT).show();
				    Preferencias.setPreferencia(ConfigActivity.this, "TipoTributacao", 1);
				    FormataTela(1);
					
			    } else if(rbSimples.getId() == checkedId) {  
			    	Toast.makeText(ConfigActivity.this, "Simples Nacional selecionado!", Toast.LENGTH_SHORT).show();
			    	Preferencias.setPreferencia(ConfigActivity.this, "TipoTributacao", 2);
			    	FormataTela(2);
			    }  
			}
		});
    }
    
    private void FormataTela(int TipoTributacaoEscolhida) {
        frmPercIRPJ = (LinearLayout) findViewById(R.id_config.frmPercIRPJ);
        frmLucroPresumido = (TableLayout) findViewById(R.id_config.frmLucroPresumido);
        frmSimplesNacional = (TableLayout) findViewById(R.id_config.frmSimplesNacional);
        
		if(TipoTributacaoEscolhida == 1) {  
		    frmPercIRPJ.setVisibility(View.VISIBLE);
		    frmLucroPresumido.setVisibility(View.VISIBLE);
		    frmSimplesNacional.setVisibility(View.GONE);
			
	    } else if(TipoTributacaoEscolhida == 2) {  
	    	frmPercIRPJ.setVisibility(View.GONE);
	    	frmLucroPresumido.setVisibility(View.GONE);
	    	frmSimplesNacional.setVisibility(View.VISIBLE);
	    }  
    }
}
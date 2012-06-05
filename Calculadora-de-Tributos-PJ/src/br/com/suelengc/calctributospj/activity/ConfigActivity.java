package br.com.suelengc.calctributospj.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.utils.Preferencias;

public class ConfigActivity extends Activity {
	
	RadioButton rbLucroPresumido, rbSimples, rb2_40, rb4_80;
	RadioGroup rgTipoTributacao, rgPercIRPJ;
	LinearLayout frmPercIRPJ;
	TableLayout frmLucroPresumido, frmSimplesNacional;
	TextView lirpj_darf;
	
	private static final int LUCRO_PRESUMIDO = 1;
	private static final int SIMPLES_NACIONAL = 2;
	private static final int INFORMACOES = Menu.FIRST;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);
        setTitle("Calculadora de Tributos PJ - Configurações");
        
        rgTipoTributacao = (RadioGroup) findViewById(R.id_config.rgTipoTributacao);
        rbLucroPresumido = (RadioButton) findViewById(R.id_config.rbLucroPresumido);
        rbSimples = (RadioButton) findViewById(R.id_config.rbSimples);
        
        rgPercIRPJ = (RadioGroup) findViewById(R.id_config.rgPercIRPJ);
        rb2_40 = (RadioButton) findViewById(R.id_config.rb2_40);
        rb4_80 = (RadioButton) findViewById(R.id_config.rb4_80);
        lirpj_darf = (TextView) findViewById(R.id_config.irpj_darf);
        
        if (Preferencias.getPreferenciaValorInteiro(ConfigActivity.this, "TipoTributacao") == 1) {
        	rbLucroPresumido.setChecked(true);
        	FormataTela(LUCRO_PRESUMIDO);
        	
        	//Lógica para carregar o IRPJ correto
			if (Preferencias.getPreferenciaValorFloat(ConfigActivity.this, "PercIRPJ") == 2.4f) {
				rb2_40.setChecked(true);
				lirpj_darf.setText("0,90%");
			} else {
			 	rb4_80.setChecked(true);
			 	lirpj_darf.setText("3,30%");
			}
			
        } else {
        	rbSimples.setChecked(true);
        	FormataTela(SIMPLES_NACIONAL);
        }
        
        rgTipoTributacao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(rbLucroPresumido.getId() == checkedId) {  
					Toast.makeText(ConfigActivity.this, "Lucro Presumido selecionado!", Toast.LENGTH_SHORT).show();
				    Preferencias.setPreferencia(ConfigActivity.this, "TipoTributacao", 1);
				    FormataTela(LUCRO_PRESUMIDO);
					
			    } else if(rbSimples.getId() == checkedId) {  
			    	Toast.makeText(ConfigActivity.this, "Simples Nacional selecionado!", Toast.LENGTH_SHORT).show();
			    	Preferencias.setPreferencia(ConfigActivity.this, "TipoTributacao", 2);
			    	FormataTela(SIMPLES_NACIONAL);
			    }  
			}
		});
        
        rgPercIRPJ.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(rb2_40.getId() == checkedId) {  
					Toast.makeText(ConfigActivity.this, "IRPJ: 2,4%", Toast.LENGTH_SHORT).show();
				    Preferencias.setPreferencia(ConfigActivity.this, "PercIRPJ", 2.4f);
				    lirpj_darf.setText("0,90%");
					
			    } else if(rb4_80.getId() == checkedId) {  
			    	Toast.makeText(ConfigActivity.this, "IRPJ: 4,8%", Toast.LENGTH_SHORT).show();
			    	Preferencias.setPreferencia(ConfigActivity.this, "PercIRPJ", 4.8f);
			    	lirpj_darf.setText("3,30%");
			    }  
			}
		});
    }
    
    private void FormataTela(int TipoTributacaoEscolhida) {
        frmPercIRPJ = (LinearLayout) findViewById(R.id_config.frmPercIRPJ);
        frmLucroPresumido = (TableLayout) findViewById(R.id_config.frmLucroPresumido);
        frmSimplesNacional = (TableLayout) findViewById(R.id_config.frmSimplesNacional);
        
		if(TipoTributacaoEscolhida == LUCRO_PRESUMIDO) {  
		    frmPercIRPJ.setVisibility(View.VISIBLE);
		    frmLucroPresumido.setVisibility(View.VISIBLE);
		    frmSimplesNacional.setVisibility(View.GONE);
			
	    } else if(TipoTributacaoEscolhida == SIMPLES_NACIONAL) {  
	    	frmPercIRPJ.setVisibility(View.GONE);
	    	frmLucroPresumido.setVisibility(View.GONE);
	    	frmSimplesNacional.setVisibility(View.VISIBLE);
	    }  
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, INFORMACOES, 0, "Informações...");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case INFORMACOES:
			Intent intent = new Intent(this, InfoActivity.class);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
}
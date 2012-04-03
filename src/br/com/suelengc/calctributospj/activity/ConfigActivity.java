package br.com.suelengc.calctributospj.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import br.com.suelengc.calctributospj.R;

public class ConfigActivity extends Activity {
	
	private static final String[] tributacao = {"Simples Nacional", "Liquido Presumido"};
	private static final String[] csll = {"12,00%", "32,00%"};
	private static final String[] irpj = {"1,60%", "8,00%", "16,00%", "32,00%"};
	
	ArrayAdapter aTributacao, aCSLL, aIRPJ;
	Spinner spnTributacao, spnCSLL, spnIRPJ;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);
        
        spnTributacao = (Spinner) findViewById(R.id.spntributacao);
        spnCSLL = (Spinner) findViewById(R.id.spncsll);
        spnIRPJ = (Spinner) findViewById(R.id.spnirpj);
        
        aTributacao = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tributacao);
        spnTributacao.setAdapter(aTributacao);
        
        aCSLL = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, csll);
        spnCSLL.setAdapter(aCSLL);
        
        aIRPJ = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, irpj);
        spnIRPJ.setAdapter(aIRPJ);
        
        
    }

}
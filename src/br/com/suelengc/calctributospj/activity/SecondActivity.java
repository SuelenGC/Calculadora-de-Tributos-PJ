package br.com.suelengc.calctributospj.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import br.com.calctributospj.R;

public class SecondActivity extends Activity {
	
    EditText edvalorhora, edtotalhoras;
	TextView tvvalor_bruto, tvvalor_liquido, tvirpj_retido, tvcofins_retido, tvpis_retido, tvcsll_retido, tvinss_darf, tvirpj_darf, tvcsll_darf;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
    }

}
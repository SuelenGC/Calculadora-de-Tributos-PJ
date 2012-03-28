package br.com.suelengc.calctributospj.activity;

import java.text.NumberFormat;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.media.ExifInterface;
import android.os.Bundle;
import android.widget.*;
import android.text.style.IconMarginSpan;
import android.view.*;
import br.com.suelengc.utils.*;
import br.com.suelengc.calctributospj.controller.*;
import br.com.suelengc.calctributospj.model.TributacaoNormal;
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
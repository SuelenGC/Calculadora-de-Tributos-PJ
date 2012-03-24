package com.calculadora.impostos.pj;

import android.app.Activity;
import android.os.Bundle;
import android.app.*;
import android.widget.*;
import android.widget.TextView.BufferType;
import android.view.*;

public class CalculadoraImpostosPJActivity extends Activity {
    EditText edvalorhora, edtotalhoras;
    EditText edvalor_liquido, edvalor_bruto, edirpj_retido, edcofins_retido, edpis_retido, edcsll_retido;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setTitle("Cálculo de Impostos PJ");
        
        //Entrada de dados
        edvalorhora = (EditText) findViewById(R.id.valorhora);
        edtotalhoras = (EditText) findViewById(R.id.totalhoras);
        
        //Saída de dados
        edvalor_liquido = (EditText) findViewById(R.id.valorliquido);
        edvalor_bruto = (EditText) findViewById(R.id.valorbruto);
        edirpj_retido = (EditText) findViewById(R.id.irpj_retido);
        edcofins_retido = (EditText) findViewById(R.id.cofins_retido);
        edpis_retido = (EditText) findViewById(R.id.pis_retido);
        edcsll_retido = (EditText) findViewById(R.id.csll_retido);
                
        Button btcalcular = (Button) findViewById(R.id.btcalcular);
        
        btcalcular.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {		        
		        double valorhora = Double.parseDouble(edvalorhora.getText().toString());
		        double totalhoras = Double.parseDouble(edtotalhoras.getText().toString());
		        double valorTotalMes = valorhora * totalhoras;
		        double resultado, valorBruto;
		        
		        valorBruto = 0;
		        
		        //Calcula IRPJ Retido
		        resultado = valorTotalMes * 0.015;
		        edirpj_retido.setText("R$ " + String.valueOf(resultado));
		        valorBruto = valorTotalMes - resultado; 
		        
		        //Calcula Cofins Retido
		        resultado = valorTotalMes * 0.03;
		        edcofins_retido.setText("R$ " + String.valueOf(resultado));
		        valorBruto = valorBruto - resultado;
		        
		        //Calcula Pis Retido
		        resultado = valorTotalMes * 0.0065;
		        edpis_retido.setText("R$ " + String.valueOf(resultado));
		        valorBruto = valorBruto - resultado;
		        
		        //Calcula CSLL Retido
		        resultado = valorTotalMes * 0.01;
		        edcsll_retido.setText("R$ " + String.valueOf(resultado));
		        valorBruto = valorBruto - resultado;
		        
		        edvalor_bruto.setText("R$ " + String.valueOf(valorBruto));
		        edvalor_liquido.setText("R$ " + String.valueOf(valorTotalMes));
			}
		});
    }
}
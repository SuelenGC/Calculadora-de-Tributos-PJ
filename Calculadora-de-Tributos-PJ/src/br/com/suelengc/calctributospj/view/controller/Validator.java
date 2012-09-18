package br.com.suelengc.calctributospj.view.controller;

import android.widget.EditText;

public class Validator {

	public boolean ValidaEditText(EditText editText) {
		boolean retorno = true;
		
		if (editText.getText().toString().equals("")) 
		{
			editText.setError("Campo obrigatório.");
			editText.requestFocus();
			retorno = false;
		}	
		
		return retorno;
	}
}

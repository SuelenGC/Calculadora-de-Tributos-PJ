package br.com.suelengc.utils;

import android.widget.EditText;

public class Validators {

	public static boolean ValidaEditText(EditText editText) {
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

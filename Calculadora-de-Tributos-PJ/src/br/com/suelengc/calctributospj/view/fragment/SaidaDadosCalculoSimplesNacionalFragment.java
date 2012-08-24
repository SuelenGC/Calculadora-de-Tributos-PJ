package br.com.suelengc.calctributospj.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.suelengc.calctributospj.R;

import com.actionbarsherlock.app.SherlockFragment;

public class SaidaDadosCalculoSimplesNacionalFragment extends SherlockFragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	
		View view = inflater.inflate(R.layout.fragment_saida_dados_calculo_simples_nacional, container, false);
		return view;
		
	}
	
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
   }
}

package br.com.suelengc.calctributospj.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import br.com.suelengc.calctributospj.R;

import com.actionbarsherlock.app.SherlockFragment;

public class EntradaDadosCalculoValorBrutoFragment extends SherlockFragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_entrada_dados_calculo_valor_bruto, container, false);
		return view;
		
	}
}

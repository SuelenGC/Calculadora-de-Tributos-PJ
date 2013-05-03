package br.com.suelengc.calctributospj.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import br.com.suelengc.calctributospj.R;

import com.actionbarsherlock.app.SherlockFragment;

public class SaidaDadosCalculoSimplesNacionalFragment extends SherlockFragment {

	TextView tvvalor_bruto, tvvalor_liquido, tvtotaldescontosmensais;
	TextView tvtributo_unificado;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_saida_dados_calculo_simples_nacional, container, false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		// -- Tributos unificado
		tvtributo_unificado = (TextView) getActivity().findViewById(R.id_calc.tributo_unificado);
		tvtributo_unificado.setText(savedInstanceState != null && savedInstanceState.getString("tributo_unificado") != null ? savedInstanceState.getString("tributo_unificado") : tvtributo_unificado
				.getText().toString());

		// -- Campos Resumo
		tvvalor_bruto = (TextView) getActivity().findViewById(R.id_calc.valorbruto);
		tvvalor_bruto.setText(savedInstanceState != null && savedInstanceState.getString("valorbruto") != null ? savedInstanceState.getString("valorbruto") : tvvalor_bruto.getText().toString());

		tvtotaldescontosmensais = (TextView) getActivity().findViewById(R.id_calc.totaldescontosmensais);
		tvtotaldescontosmensais.setText(savedInstanceState != null && savedInstanceState.getString("totaldescontosmensais") != null ? savedInstanceState.getString("totaldescontosmensais")
				: tvtotaldescontosmensais.getText().toString());

		tvvalor_liquido = (TextView) getActivity().findViewById(R.id_calc.valorliquido);
		tvvalor_liquido.setText(savedInstanceState != null && savedInstanceState.getString("valorliquido") != null ? savedInstanceState.getString("valorliquido") : tvvalor_liquido.getText()
				.toString());

	}

	@Override
	public void onSaveInstanceState(Bundle outState) {

		// -- Tributo unificado
		outState.putString("tributo_unificado", ((TextView) getActivity().findViewById(R.id_calc.tributo_unificado)).getText().toString());

		// -- Campos Resumo
		outState.putString("valorbruto", ((TextView) getActivity().findViewById(R.id_calc.valorbruto)).getText().toString());
		outState.putString("totaldescontosmensais", ((TextView) getActivity().findViewById(R.id_calc.totaldescontosmensais)).getText().toString());
		outState.putString("valorliquido", ((TextView) getActivity().findViewById(R.id_calc.valorliquido)).getText().toString());
		super.onSaveInstanceState(outState);
	}
}

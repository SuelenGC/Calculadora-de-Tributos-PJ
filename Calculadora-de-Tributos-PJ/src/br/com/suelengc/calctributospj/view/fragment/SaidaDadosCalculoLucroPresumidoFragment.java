package br.com.suelengc.calctributospj.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.domain.TipoTributacao;
import br.com.suelengc.calctributospj.preference.PreferenciasCalculo;

import com.actionbarsherlock.app.SherlockFragment;

public class SaidaDadosCalculoLucroPresumidoFragment extends SherlockFragment {

	TextView tvvalor_bruto, tvvalor_liquido, tvtotaldescontosmensais;
	TextView tvirpj_retido, tvcofins_retido, tvpis_retido, tvcsll_retido, tviss_darf, tvirpj_darf, tvcsll_darf;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_saida_dados_calculo_lucro_presumido, container, false);

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		//-- Tributos mensais
		tvirpj_retido = (TextView) getActivity().findViewById(R.id_calc.irpj_retido);
		tvirpj_retido.setText(savedInstanceState != null && savedInstanceState.getString("irpj_retido") != null ? savedInstanceState.getString("irpj_retido") : tvirpj_retido.getText().toString());

		tvcsll_retido = (TextView) getActivity().findViewById(R.id_calc.csll_retido);
		tvcsll_retido.setText(savedInstanceState != null && savedInstanceState.getString("csll_retido") != null ? savedInstanceState.getString("csll_retido") : tvcsll_retido.getText().toString());

		tvpis_retido = (TextView) getActivity().findViewById(R.id_calc.pis_retido);
		tvpis_retido.setText(savedInstanceState != null && savedInstanceState.getString("pis_retido") != null ? savedInstanceState.getString("pis_retido") : tvpis_retido.getText().toString());

		tvcofins_retido = (TextView) getActivity().findViewById(R.id_calc.cofins_retido);
		tvcofins_retido.setText(savedInstanceState != null && savedInstanceState.getString("cofins_retido") != null ? savedInstanceState.getString("cofins_retido") : tvcofins_retido.getText().toString());

		tviss_darf = (TextView) getActivity().findViewById(R.id_calc.iss_darf);
		tviss_darf.setText(savedInstanceState != null && savedInstanceState.getString("iss_darf") != null ? savedInstanceState.getString("iss_darf") : tviss_darf.getText().toString());

		//-- Tributos trimestrais
		tvirpj_darf = (TextView) getActivity().findViewById(R.id_calc.irpj_darf);
		tvirpj_darf.setText(savedInstanceState != null && savedInstanceState.getString("irpj_darf") != null ? savedInstanceState.getString("irpj_darf") : tvirpj_darf.getText().toString());

		tvcsll_darf = (TextView) getActivity().findViewById(R.id_calc.csll_darf);
		tvcsll_darf.setText(savedInstanceState != null && savedInstanceState.getString("csll_darf") != null ? savedInstanceState.getString("csll_darf") : tvcsll_darf.getText().toString());

		//-- Campos Resumo
		tvvalor_bruto = (TextView) getActivity().findViewById(R.id_calc.valorbruto);
		tvvalor_bruto.setText(savedInstanceState != null && savedInstanceState.getString("valorbruto") != null ? savedInstanceState.getString("valorbruto") : tvvalor_bruto.getText().toString());

		tvtotaldescontosmensais = (TextView) getActivity().findViewById(R.id_calc.totaldescontosmensais);
		tvtotaldescontosmensais.setText(savedInstanceState != null && savedInstanceState.getString("totaldescontosmensais") != null ? savedInstanceState.getString("totaldescontosmensais") : tvtotaldescontosmensais.getText().toString());

		tvvalor_liquido = (TextView) getActivity().findViewById(R.id_calc.valorliquido);
		tvvalor_liquido.setText(savedInstanceState != null && savedInstanceState.getString("valorliquido") != null ? savedInstanceState.getString("valorliquido") : tvvalor_liquido.getText().toString());

		//Toast.makeText(getActivity(),"ANTES - " +  (savedInstanceState != null && savedInstanceState.getString("valorliquido") != null ? "savedInstanceState: " + savedInstanceState.getString("valorliquido") + " / tvvalor_liquido: " + tvvalor_liquido.getText().toString() : "savedInstanceState is null"  + " / tvvalor_liquido: " + tvvalor_liquido.getText().toString()), Toast.LENGTH_LONG).show();
		//Toast.makeText(getActivity(),"DEPOIS - " +  (savedInstanceState != null && savedInstanceState.getString("valorliquido") != null ? "savedInstanceState: " + savedInstanceState.getString("valorliquido") + " / tvvalor_liquido: " + tvvalor_liquido.getText().toString() : "savedInstanceState is null"  + " / tvvalor_liquido: " + tvvalor_liquido.getText().toString()), Toast.LENGTH_LONG).show();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		
		//-- Tributos mensais
		outState.putString("irpj_retido", ((TextView) getActivity().findViewById(R.id_calc.irpj_retido)).getText().toString());
		outState.putString("csll_retido", ((TextView) getActivity().findViewById(R.id_calc.csll_retido)).getText().toString());
		outState.putString("pis_retido", ((TextView) getActivity().findViewById(R.id_calc.pis_retido)).getText().toString());
		outState.putString("cofins_retido", ((TextView) getActivity().findViewById(R.id_calc.cofins_retido)).getText().toString());
		outState.putString("iss_darf", ((TextView) getActivity().findViewById(R.id_calc.iss_darf)).getText().toString());

		//-- Tributos mensais
		outState.putString("irpj_darf", ((TextView) getActivity().findViewById(R.id_calc.irpj_darf)).getText().toString());
		outState.putString("csll_darf", ((TextView) getActivity().findViewById(R.id_calc.csll_darf)).getText().toString());

		//-- Campos Resumo
		outState.putString("valorbruto", ((TextView) getActivity().findViewById(R.id_calc.valorbruto)).getText().toString());
		outState.putString("totaldescontosmensais", ((TextView) getActivity().findViewById(R.id_calc.totaldescontosmensais)).getText().toString());
		outState.putString("valorliquido", ((TextView) getActivity().findViewById(R.id_calc.valorliquido)).getText().toString());

		super.onSaveInstanceState(outState);
	}

}

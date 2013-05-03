package br.com.suelengc.calctributospj.view.activity;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.preference.Preferencias;

public class NewsDialogFragment extends DialogFragment implements android.view.View.OnClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.news, container, false);

		view.findViewById(R.id_new_features.close).setOnClickListener(this);
		view.findViewById(R.id_new_features.close_forever).setOnClickListener(this);

		getDialog().setTitle("Conheça as novidades!");

		return view;
	}

	@Override
	public void onClick(View view) {
		Preferencias p = new Preferencias(getActivity());

		if (view.getId() == R.id_new_features.close_forever) {
			p.setBoolean("view_news", true);
		}

		this.dismiss();
	}
}

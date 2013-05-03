package br.com.suelengc.calctributospj.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.preference.Preferencias;

public class RatingDialogFragment extends DialogFragment implements android.view.View.OnClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.rating, container, false);

		view.findViewById(R.id_rating.i_love_it).setOnClickListener(this);
		view.findViewById(R.id_rating.needs_work).setOnClickListener(this);
		view.findViewById(R.id_rating.maybe_later).setOnClickListener(this);

		getDialog().setTitle("Gostaria de avaliar?");
		
		return view;
	}

	@Override
	public void onClick(View view) {
		Intent intent = null;
		Preferencias p = new Preferencias(getActivity());
		
		switch (view.getId()) {
		case R.id_rating.i_love_it:
			p.setBoolean("rate", true);
			
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=br.com.suelengc.calctributospj"));
			startActivity(intent);
			break;

		case R.id_rating.needs_work:
			p.setBoolean("rate", true); 
			
			intent = new Intent(android.content.Intent.ACTION_SEND);
			intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] { "suelengcarvalho@gmail.com" });
			intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "[Calculadora Tributos PJ] Precisa Melhorar!");
			intent.setType("plain/text");
			startActivity(intent);
			break;

		case R.id_rating.maybe_later:
			break;
		}
		
		this.dismiss();
	}
}

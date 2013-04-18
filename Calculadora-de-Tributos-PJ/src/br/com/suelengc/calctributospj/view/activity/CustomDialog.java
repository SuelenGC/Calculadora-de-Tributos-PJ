package br.com.suelengc.calctributospj.view.activity;

import android.content.Context;
import android.preference.DialogPreference;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.preference.PreferenciasCalculo;
import br.com.suelengc.calctributospj.view.controller.Formatter;

public class CustomDialog extends DialogPreference {

	public CustomDialog(Context context, AttributeSet attrs) {
		super(context, attrs);
		setDialogLayoutResource(R.layout.dialog);
		setNegativeButtonText("Fechar");
		setPositiveButtonText("");
	}	
	
	@Override
	protected void onBindDialogView(View view) {
		TextView txtIssDarf = (TextView) view.findViewById(R.id_dialog.iss_darf);
		PreferenciasCalculo preferenciasCalculo = new PreferenciasCalculo(getContext());
		
		String percentIss = Formatter.DoubleToString(preferenciasCalculo.getPercentISS());
		txtIssDarf.setText(percentIss + "%");
		
		super.onBindDialogView(view);
	}
}

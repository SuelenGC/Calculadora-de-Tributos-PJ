package br.com.suelengc.calctributospj.view.activity;

import br.com.suelengc.calctributospj.R;
import android.content.Context;
import android.preference.DialogPreference;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class CustomDialog extends DialogPreference {

	public CustomDialog(Context context, AttributeSet attrs) {
		super(context, attrs);
		setDialogLayoutResource(R.layout.dialog);
		setNegativeButtonText("Fechar");
		setPositiveButtonText("");
	}	
}

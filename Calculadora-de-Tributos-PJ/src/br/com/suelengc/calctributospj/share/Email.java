package br.com.suelengc.calctributospj.share;

import android.content.Context;
import android.content.Intent;

public class Email {

	public void openIntentEmail(Context context) {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("message/rfc822");
		String[] emails = {"suelengcarvalho@gmail.com"};
		intent.putExtra(Intent.EXTRA_EMAIL, emails);
		intent.putExtra(Intent.EXTRA_SUBJECT, "Calculadora Tributos PJ - Feedback");
		context.startActivity(Intent.createChooser(intent, "Selecione a aplicação de email:"));
	}
}

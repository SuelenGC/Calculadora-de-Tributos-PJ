package br.com.suelengc.calctributospj.view.activity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import br.com.suelengc.calctributospj.R;
import br.com.suelengc.calctributospj.domain.TipoBaseCalculo;
import br.com.suelengc.calctributospj.domain.TipoTributacao;
import br.com.suelengc.calctributospj.model.NotaFiscal;
import br.com.suelengc.calctributospj.preference.Preferencias;
import br.com.suelengc.calctributospj.preference.PreferenciasCalculo;
import br.com.suelengc.calctributospj.share.Email;
import br.com.suelengc.calctributospj.view.fragment.EntradaDadosCalculoValorBrutoFragment;
import br.com.suelengc.calctributospj.view.fragment.EntradaDadosCalculoValorPorHoraFragment;
import br.com.suelengc.calctributospj.view.fragment.SaidaDadosCalculoLucroPresumidoFragment;
import br.com.suelengc.calctributospj.view.fragment.SaidaDadosCalculoSimplesNacionalFragment;
import br.com.suelengc.calctributospj.view.listener.CalcularListener;
import br.com.suelengc.calctributospj.view.listener.CalcularListener.CalculatorCallback;
import br.com.suelengc.calctributospj.view.menu.MyMenu;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class CalculatorActivity extends BaseActivity implements CalculatorCallback {

	public static final String EXTRA_FORMATO_TELA = "1";
	Button btnCalcular;
	TipoBaseCalculo baseCalculo;
	NotaFiscal notaFiscal;

	PreferenciasCalculo preferencias;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculator);

		baseCalculo = (TipoBaseCalculo) getIntent().getSerializableExtra(EXTRA_FORMATO_TELA);

		GradientDrawable bg = (GradientDrawable) getResources().getDrawable(R.drawable.bg_gradient);
		getSupportActionBar().setBackgroundDrawable(bg);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		// Impedir que o teclado seja aberto ao abrir a activity
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

		// Carrega preferencias de calculo
		preferencias = new PreferenciasCalculo(getApplicationContext());
		if (baseCalculo.equals(TipoBaseCalculo.VALOR_BRUTO)) {
			setTitle("Cálculo pelo Valor Bruto");

		} else {
			setTitle("Cálculo pelo Valor/Hora");
		}

		if (savedInstanceState == null) {
			/** Cria fragment entrada */
			FragmentManager fm = getSupportFragmentManager();
			FragmentTransaction ft = fm.beginTransaction();
			SherlockFragment myFragmentDadosEntrada = null;

			/**
			 * Escolhe qual fragment de entrada será apresentado a depender do
			 * tipo do tributo
			 */
			if (baseCalculo.equals(TipoBaseCalculo.VALOR_BRUTO)) {
				myFragmentDadosEntrada = new EntradaDadosCalculoValorBrutoFragment();
			} else {
				myFragmentDadosEntrada = new EntradaDadosCalculoValorPorHoraFragment();
			}
			ft.replace(R.id_calc.dadosEntradaCalculo, myFragmentDadosEntrada);
			ft.commit();

			/** Cria fragment saida */
			SherlockFragment myFragmentDadosSaida = null;

			FragmentManager fragmentManager = getSupportFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

			if (preferencias.getTipoTributacao().equals(TipoTributacao.LUCRO_PRESUMIDO)) {
				myFragmentDadosSaida = new SaidaDadosCalculoLucroPresumidoFragment();

			} else if (preferencias.getTipoTributacao().equals(TipoTributacao.SIMPLES_NACIONAL)) {
				myFragmentDadosSaida = new SaidaDadosCalculoSimplesNacionalFragment();
			}

			fragmentTransaction.replace(R.id_calc.dadosSaidaCalculo, myFragmentDadosSaida);
			fragmentTransaction.commit();
		}

		// Mostrar popup para avaliação
		Preferencias p = new Preferencias(this);
		boolean rate = p.getBoolean("rate");
		if (rate == false) {
			RatingDialogFragment ratingDialogFragment = new RatingDialogFragment();
			ratingDialogFragment.show(getSupportFragmentManager(), "dialog");
		}
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		notaFiscal = (NotaFiscal) savedInstanceState.getSerializable("notaFiscal");

		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onStart() {
		super.onStart();

		CalcularListener calcularListener = new CalcularListener(preferencias, baseCalculo, this);

		btnCalcular = (Button) findViewById(R.id_calc.btcalcular);
		btnCalcular.setOnClickListener(calcularListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater mi = new MenuInflater(getApplicationContext());
		mi.inflate(R.menu.menu, menu);

		// Ocultar menus desta tela
		menu.findItem(MyMenu.SETTINGS).setVisible(false);
		menu.findItem(MyMenu.ABOUT).setVisible(false);

		return true;
	}

	@Override
	public void onFinishCalculator(boolean sucess, NotaFiscal notaFiscal) {
		if (sucess) {
			this.notaFiscal = notaFiscal;
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putSerializable("notaFiscal", notaFiscal);
		super.onSaveInstanceState(outState);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MyMenu.COPY:
			if (!isNotaFiscalIsNull()) {
				copyToTransferArea();
			}
			return true;

		case MyMenu.EMAIL:
			if (!isNotaFiscalIsNull()) {
				sendViaEmail();
			}
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	private boolean isNotaFiscalIsNull() {
		if (notaFiscal == null) {
			Toast.makeText(this, "Você deve calcular antes de copiar", Toast.LENGTH_LONG).show();
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	private void copyToTransferArea() {
		String content = notaFiscal.toString();

		int sdk = android.os.Build.VERSION.SDK_INT;
		if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
			android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
			clipboard.setText(content.toString());

		} else {
			ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
			ClipData clip = ClipData.newPlainText("tributos", content.toString());
			clipboard.setPrimaryClip(clip);
		}

		Toast.makeText(this, "Copiado para a área de transferência", Toast.LENGTH_LONG).show();
	}

	private void sendViaEmail() {
		Email email = new Email();
		email.setContent(notaFiscal.toString());
		email.openIntentEmail(this);
	}

}
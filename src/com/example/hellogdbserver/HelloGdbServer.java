package com.example.hellogdbserver;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelloGdbServer extends Activity {
	static {
		System.loadLibrary("hello-gdbserver");
	}

	private OnClickListener induceCrashListener = new OnClickListener() {
		// When the button is clicked, induce a crash via the native code.
		public void onClick(View v) {
			invokeCrash();
		}
	};

	private OnClickListener sayHelloListener = new OnClickListener() {
		public void onClick(View v) {
			String msg = sayHello("RAYCAD");

			AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
			builder.setMessage(msg);
			builder.setCancelable(true);
			builder.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
				}
			});

			AlertDialog alertDlg = builder.create();
			alertDlg.show();
		}
	};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button button = (Button) findViewById(R.id.induceCrashButton);
		button.setOnClickListener(induceCrashListener);

		button = (Button) findViewById(R.id.sayHelloButton);
		button.setOnClickListener(sayHelloListener);
	}

	public static native void invokeCrash();
	public static native String sayHello(String name);
}
package com.brent.brentsapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

		TextView text = (TextView)findViewById(R.id.mainTextView);
		text.setText("Still 140 characters left.");

		Button clear = (Button)findViewById(R.id.clearButton);
        clear.setOnClickListener(new OnClickListener() 
        {   public void onClick(View v) 
            {   
                new AlertDialog.Builder(MainActivity.this)
                .setTitle("Confirm")
                .setMessage("Your message will not be sent or read!")
                .setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                		EditText edit = (EditText)findViewById(R.id.mainEditText);
                		edit.setText("");
                    }
                })
                .show();
            }
        });
    
        Button exit = (Button)findViewById(R.id.exitButton);
        exit.setOnClickListener(new OnClickListener() 
        {   public void onClick(View v) 
            {   
        		finish();
            }
        });
        
		EditText edit = (EditText) findViewById(R.id.mainEditText);
        edit.requestFocus();
        getWindow().setSoftInputMode(LayoutParams.SOFT_INPUT_STATE_VISIBLE);
		TextWatcher listener = new TextWatcher() {
			public void afterTextChanged(Editable s) {
			}
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				EditText edit = (EditText) findViewById(R.id.mainEditText);
				TextView text = (TextView)findViewById(R.id.mainTextView);
				int length = edit.getText().length();
				if (length > 140) {
					text.setTextColor(Color.RED);
					text.setText("Nobody will read that!!! (-" + (length - 140) + " characters)");
				} else {
					text.setTextColor(Color.BLACK);
					text.setText("Still " + (140 - length) + " characters left.");
				}
			}
		};
		edit.addTextChangedListener(listener);
    }
}

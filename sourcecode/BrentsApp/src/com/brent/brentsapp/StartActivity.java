package com.brent.brentsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startactivity);

        Button start = (Button)findViewById(R.id.startButton);
        start.setOnClickListener(new OnClickListener() 
        {   public void onClick(View v) 
            {   
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);      
                finish();
            }
        });
    
    }

}

package com.example.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MemoriaStart extends Activity {

    Button mStart;
    Button mExit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        mStart = (Button)findViewById(R.id.startBut);
        mExit = (Button)findViewById(R.id.exitBut);

        mStart.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });

        mExit.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void startGame () {
        Intent i = new Intent(this, MainActivity.class);
        startActivity (i);
    }
}

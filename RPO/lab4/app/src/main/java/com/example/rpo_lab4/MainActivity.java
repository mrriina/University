package com.example.rpo_lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.TooltipCompat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button chooseBut;

    private Button aboutBut;

    private Button exitBut;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
        chooseBut = (Button) findViewById(R.id.choose);
        aboutBut = (Button) findViewById(R.id.about);
        exitBut = (Button) findViewById(R.id.exit);

        View chooseButView = findViewById(R.id.choose);
        TooltipCompat.setTooltipText(chooseButView, "Click to select activity to open");

        View aboutButView = findViewById(R.id.about);
        TooltipCompat.setTooltipText(aboutButView, "Click if you want to read about the app");

        View exitButView = findViewById(R.id.exit);
        TooltipCompat.setTooltipText(exitButView, "Click if you want to exit the app");


        chooseBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Choose activity");
                final String[] rivers = {"All gestures", "Some gestures"};
                builder.setItems(rivers, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int river) {
                                switch(river) {
                                    case 0:
                                        Intent intent = new Intent(MainActivity.this, AllGestures.class);
                                        startActivity(intent);
                                        break;
                                    case 1:
                                        Intent intent2 = new Intent(MainActivity.this, SomeGestures.class);
                                        startActivity(intent2);
                                        break;
                                }
                            }
                        }
                );
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


        aboutBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { aboutButtonHandler(); }
        });


        exitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish(); }
        });
    }

    private void aboutButtonHandler(){
        AlertDialog.Builder alertbox = new AlertDialog.Builder(MainActivity.this);
        alertbox.setTitle("About");
        alertbox.setMessage("This application is developed by Marina Yuskovets, " +
                            "a student of the PO-6 group. " +
                            "It allows you to use all standard gestures or only some of them.");
        alertbox.setCancelable(true);

        alertbox.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {}
        });

        AlertDialog alertbox2 = alertbox.create();
        alertbox2.show();
    }
}
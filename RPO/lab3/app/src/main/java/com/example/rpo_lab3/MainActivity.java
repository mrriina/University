package com.example.rpo_lab3;

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

    private Button exitBut;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
        chooseBut = (Button) findViewById(R.id.chooseBut);
        exitBut = (Button) findViewById(R.id.exit);

        View chooseButView = findViewById(R.id.chooseBut);
        TooltipCompat.setTooltipText(chooseButView, "Click to select a lake to find out more information about it!");

        View exitButView = findViewById(R.id.exit);
        TooltipCompat.setTooltipText(exitButView, "Click if you want to exit the app");

        chooseBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Choose Lake");
                final String[] rivers = {"Naroch", "Drivyaty", "Belaye", "Svityaz", "Chervonoye"};
                builder.setItems(rivers, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int river) {
                                switch(river) {
                                    case 0:
                                        Intent intent = new Intent(MainActivity.this, Naroch.class);
                                        startActivity(intent);
                                        break;
                                    case 1:
                                        Intent intent2 = new Intent(MainActivity.this, Drivyaty.class);
                                        startActivity(intent2);
                                        break;
                                    case 2:
                                        Intent intent3 = new Intent(MainActivity.this, Belaye.class);
                                        startActivity(intent3);
                                        break;
                                    case 3:
                                        Intent intent4 = new Intent(MainActivity.this, Svityaz.class);
                                        startActivity(intent4);
                                        break;
                                    case 4:
                                        Intent intent5 = new Intent(MainActivity.this, Chervonoye.class);
                                        startActivity(intent5);
                                        break;
                                }
                            }
                        }
                );
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


        exitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish(); }
        });
    }
}
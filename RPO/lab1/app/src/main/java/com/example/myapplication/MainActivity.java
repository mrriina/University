package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private GridView mGrid;
    private GridAdapter mAdapter;

    private TextView mStepScreen;

    private TextView mMotivText;
    private Chronometer mTimeScreen;

    private Integer StepCount; // кол-во ходов

    Button mBack;
    Button mAgain;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBack = (Button)findViewById(R.id.backBut);
        mAgain = (Button)findViewById(R.id.againBut);

        mBack.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });

        mAgain.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAgain();
            }
        });

        mGrid = (GridView)findViewById(R.id.field);
        mGrid.setNumColumns(4);
        mGrid.setEnabled(true);

        mAdapter = new GridAdapter(this, 4, 4);
        mGrid.setAdapter(mAdapter);

        mTimeScreen = (Chronometer) findViewById(R.id.timeview);
        mStepScreen = (TextView)findViewById(R.id.stepview);
        mMotivText = (TextView)findViewById(R.id.motivationText);


        StepCount = 0;
        mStepScreen.setText (StepCount.toString());

        mTimeScreen.start();


        mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,int position, long id) {

                mAdapter.checkOpenCells ();
                if (mAdapter.openCell (position)) {
                    StepCount ++;
                    mStepScreen.setText (StepCount.toString());
                    mMotivText.setText(mAdapter.getMotivText());
                }

                if (mAdapter.checkGameOver())
                {
                    mTimeScreen.stop();
                    String time = mTimeScreen.getText().toString();
                    String TextToast = "Игра закончена nХодов: " + StepCount.toString() + "nВремя: " + time;
                    Toast.makeText (getApplicationContext(), TextToast, Toast.LENGTH_SHORT).show();
                }

                if (mAdapter.checkGameOver())
                {
                    mTimeScreen.stop();
                    ShowGameOver();
                }
            }
        });
    }

    private void openMenu () {
        finish();
    }

    private void startAgain () {
        finish();
        Intent i = new Intent(this, MainActivity.class);
        startActivity (i);
    }

    private void ShowGameOver () {

        // Диалоговое окно
        AlertDialog.Builder alertbox = new AlertDialog.Builder(this);

        // Заголовок и текст
        alertbox.setTitle("Поздравляем!");
        String time = mTimeScreen.getText().toString();
        String TextToast = "Игра закончена nХодов: " + StepCount.toString() + "nВремя: " + time;
        alertbox.setMessage(TextToast);

        // Добавляем кнопку
        alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                // закрываем текущюю Activity
                finish();
            }
        });
        // показываем окно
        alertbox.show();
    }
}
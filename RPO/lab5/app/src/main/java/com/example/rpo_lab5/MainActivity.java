package com.example.rpo_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity implements
        GestureOverlayView.OnGesturePerformedListener {
    private GestureLibrary gLib;
    private GestureOverlayView gestures;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.gLib = GestureLibraries.fromRawResource(this, R.raw.gesture);
        if (!gLib.load()) {
            finish();
        }
        gestures = (GestureOverlayView) findViewById(R.id.gestureOverlayView);
        gestures.addOnGesturePerformedListener(this);
    }
    @Override
    public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
        ArrayList<Prediction> predictions = gLib.recognize(gestures.getGesture());
        if (predictions.size() > 0) {
            Prediction prediction = predictions.get(0);
            if (prediction.score > 1.0) {

                if (prediction.name.equals("1"))
                    Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();
                else if (prediction.name.equals("2"))
                    Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_SHORT).show();
                else if (prediction.name.equals("3"))
                    Toast.makeText(getApplicationContext(), "3", Toast.LENGTH_SHORT).show();
                else if (prediction.name.equals("4"))
                    Toast.makeText(getApplicationContext(), "4", Toast.LENGTH_SHORT).show();
                else if (prediction.name.equals("5"))
                    Toast.makeText(getApplicationContext(), "5", Toast.LENGTH_SHORT).show();
                else if (prediction.name.equals("about"))
                    aboutHandler();
                else if (prediction.name.equals("exit"))
                    this.finishAffinity();
            } else {
                Toast.makeText(getApplicationContext(), "The gesture is unrecognized", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void aboutHandler(){
        System.out.println("in aboutHandler method");
        AlertDialog.Builder alertbox = new AlertDialog.Builder(MainActivity.this);
        alertbox.setTitle("About");
        alertbox.setMessage("The application was developed by Marina Yuskovets, " +
                "a student of the PO-6 group for gesture recognition. " +
                "Gestures that can be entered: 1, 2, 3, 4, 5, a(about), e(exit).");
        alertbox.setCancelable(true);

        alertbox.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {}
        });

        AlertDialog alertbox2 = alertbox.create();
        alertbox2.show();
    }
}
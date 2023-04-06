package com.example.rpo_lab4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

public class SomeGestures extends AppCompatActivity {
    private GestureDetectorCompat mDetector;
    private TextView some;

    ImageView imageView;

    Button backBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.some);

        backBut = (Button) findViewById(R.id.back);
        some = findViewById(R.id.some_textView);
        imageView = findViewById(R.id.my_image_view);
        mDetector=new GestureDetectorCompat(this, new MyGestListener());

        backBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish(); }
        });
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
    class MyGestListener extends GestureDetector.SimpleOnGestureListener {
        @SuppressLint("SetTextI18n")
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            some.setText("onFling: " + event1.toString()+event2.toString());
            Toast.makeText(getApplicationContext(), "onFling gesture", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.all_fling);
            return true;
        }
        @SuppressLint("SetTextI18n")
        @Override
        public void onLongPress(MotionEvent event) {
            some.setText("onLongPress: " + event.toString());
            Toast.makeText(getApplicationContext(), "onLongPress gesture", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.all_longpress);
        }
        @SuppressLint("SetTextI18n")
        @Override
        public void onShowPress(MotionEvent event) {
            some.setText("onShowPress: " + event.toString());
            Toast.makeText(getApplicationContext(), "onShowPress gesture", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.all_showpress);
        }
    }
}

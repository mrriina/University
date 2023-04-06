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

public class AllGestures extends AppCompatActivity implements
        GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
        private TextView all;
        ImageView imageView;

        Button backBut;
        private GestureDetectorCompat mDetector;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.all);

            backBut = (Button) findViewById(R.id.back);
            all = findViewById(R.id.all_textView);
            imageView = findViewById(R.id.my_image_view);
            mDetector = new GestureDetectorCompat(this,this);
            mDetector.setOnDoubleTapListener(this);

            backBut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { finish(); }
            });
        }
        public boolean onTouchEvent(MotionEvent event){
            this.mDetector.onTouchEvent(event);
            return super.onTouchEvent(event);
        }
        @SuppressLint("SetTextI18n")
        @Override
        public boolean onDoubleTap(MotionEvent event) {
            all.setText("onDoubleTap: " + event.toString());
            Toast.makeText(getApplicationContext(), "onDoubleTap gesture", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.all_doubletap);
            return true;
        }
        @SuppressLint("SetTextI18n")
        @Override
        public boolean onDoubleTapEvent(MotionEvent event) {
            all.setText("onDoubleTapEvent: " + event.toString());
            Toast.makeText(getApplicationContext(), "onDoubleTapEvent gesture", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.all_doubletap);
            return true;
        }
        @SuppressLint("SetTextI18n")
        @Override

        public boolean onSingleTapConfirmed(MotionEvent event) {
            all.setText("onSingleTapConfirmed: " + event.toString());
            Toast.makeText(getApplicationContext(), "onSingleTapConfirmed gesture", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.all_singletap);
            return true;
        }

        @SuppressLint("SetTextI18n")
        @Override
        public boolean onDown(MotionEvent event) {
            all.setText("onDown: " + event.toString());
            Toast.makeText(getApplicationContext(), "onDown gesture", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.all_down);
            return false;
        }
        @SuppressLint("SetTextI18n")
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            all.setText("onFling: " + event1.toString()+event2.toString());
            Toast.makeText(getApplicationContext(), "onFling gesture", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.all_fling);
            return true;
        }
        @SuppressLint("SetTextI18n")
        @Override
        public void onLongPress(MotionEvent event) {
            all.setText("onLongPress: " + event.toString());
            Toast.makeText(getApplicationContext(), "onLongPress gesture", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.all_longpress);
        }
        @SuppressLint("SetTextI18n")
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                                float distanceY) {
            all.setText("onScroll: " + e1.toString()+e2.toString());
            Toast.makeText(getApplicationContext(), "onScroll gesture", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.all_scroll);
            return true;
        }
        @SuppressLint("SetTextI18n")
        @Override
        public void onShowPress(MotionEvent event) {
            all.setText("onShowPress: " + event.toString());
            Toast.makeText(getApplicationContext(), "onShowPress gesture", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.all_showpress);
        }
        @SuppressLint("SetTextI18n")
        @Override
        public boolean onSingleTapUp(MotionEvent event) {
            all.setText("onSingleTapUp: " + event.toString());
            Toast.makeText(getApplicationContext(), "onSingleTapUp gesture", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.all_singletapup);
            return true;
        }
}

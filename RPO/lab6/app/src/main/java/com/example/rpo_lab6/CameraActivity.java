package com.example.rpo_lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraActivity extends AppCompatActivity {
    Button btnTakePhoto;
    ImageView imageView;

    Button backBut;

    public static final int RequestPermissionCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        btnTakePhoto = findViewById(R.id.camera_button);
        imageView = findViewById(R.id.camera_imageView);
        EnableRuntimePermission();
        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 7);
            }
        });

        backBut = (Button) findViewById(R.id.back);

        backBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish(); }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 7 && resultCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }
    }

    public void EnableRuntimePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(CameraActivity.this,
                Manifest.permission.CAMERA)) {
            Toast.makeText(
                    CameraActivity.this,
                    "CAMERA permission allows us to Access CAMERA app",
                    Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(CameraActivity.this, new String[]{
                    Manifest.permission.CAMERA}, RequestPermissionCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] result) {
        super.onRequestPermissionsResult(requestCode, permissions, result);
        switch (requestCode) {
            case RequestPermissionCode:
                if (result.length > 0 && result[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(
                            CameraActivity.this,
                            "Permission Granted, Now your application can access CAMERA.",
                            Toast.LENGTH_LONG
                    ).show();
                } else {
                    Toast.makeText(
                            CameraActivity.this,
                            "Permission Canceled, Now your application cannot access CAMERA.",
                            Toast.LENGTH_LONG
                    ).show();
                }
                break;
        }
    }
}
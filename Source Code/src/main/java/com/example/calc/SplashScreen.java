package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {
    Vibrator vib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        new Handler().postDelayed(() -> {
            Intent i = new Intent(SplashScreen.this, HomeScreen.class);
            vib.vibrate(500);
            startActivity(i);
            finish();
        }, 4500);
    }
}
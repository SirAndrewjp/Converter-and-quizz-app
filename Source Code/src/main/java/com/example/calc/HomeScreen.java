package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {
Button tocalc, Quizz;
Vibrator vibrate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        vibrate = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        tocalc = findViewById(R.id.tocalc);
        Quizz = findViewById(R.id.quizz);
        Quizz.setOnClickListener(v -> new Handler().postDelayed(() -> {
            Intent i = new Intent(HomeScreen.this, QuizActivity.class);
            vibrate.vibrate(100);
            startActivity(i);
            finish();
        }, 10));

        tocalc.setOnClickListener(v -> new Handler().postDelayed(()->{
            Intent i = new Intent(HomeScreen.this, MainActivity.class);
            vibrate.vibrate(100);
            startActivity(i);
            finish();
        },10));

    }
}
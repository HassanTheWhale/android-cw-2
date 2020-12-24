package com.example.cw5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoadingActivy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_activy);

        Handler h = new Handler(getMainLooper());
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(LoadingActivy.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
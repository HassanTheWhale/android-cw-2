package com.example.cw5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("name");
        String age = bundle.getString("age");

        TextView nameView = findViewById(R.id.textView6);
        TextView ageView = findViewById(R.id.textView7);

        nameView.setText(name);
        ageView.setText(age);

        Button backBtn = findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Info.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
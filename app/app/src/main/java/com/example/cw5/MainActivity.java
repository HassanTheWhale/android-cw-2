package com.example.cw5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = findViewById(R.id.name);
        final EditText age = findViewById(R.id.age);
        final EditText number = findViewById(R.id.phone);
        final EditText email = findViewById(R.id.email);
        final EditText address = findViewById(R.id.adress);

        Button nextBtn = findViewById(R.id.nextPage);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = name.getText().toString();
                String userAge = age.getText().toString();
                String userNumber = number.getText().toString();
                String userEmail = email.getText().toString();
                String userAddress = address.getText().toString();

                if (userName == null || userName.isEmpty() || userAge.isEmpty() || userAge == null   ||   userNumber == null || userNumber.isEmpty() || userEmail.isEmpty() || userEmail == null || userAddress.isEmpty() || userAddress == null) {
                    Toast.makeText(MainActivity.this, "تأكد من البيانات!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent(MainActivity.this, Info.class);
                i.putExtra("name", userName);
                i.putExtra("age", userAge);
                i.putExtra("phone", userNumber);
                i.putExtra("email", userEmail);
                i.putExtra("address", userAddress);
                startActivity(i);
                finish();
            }
        });


    }
}
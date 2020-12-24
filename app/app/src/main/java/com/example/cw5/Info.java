package com.example.cw5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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

        final String name = bundle.getString("name");
        String age = bundle.getString("age");
        final String phone = bundle.getString("phone");
        final String email = bundle.getString("email");
        final String address = bundle.getString("address");

        TextView nameView = findViewById(R.id.textView6);
        TextView ageView = findViewById(R.id.textView7);
        final TextView phoneView = findViewById(R.id.textView10);
        final TextView emailView = findViewById(R.id.textView12);
        final TextView addressView = findViewById(R.id.textView14);

        nameView.setText(name);
        ageView.setText(age);
        phoneView.setText(phone);
        emailView.setText(email);
        addressView.setText(address);

        Button backBtn = findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Info.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        phoneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:"+phone));
                startActivity(call);
            }
        });

        emailView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_SEND);
                call.putExtra(Intent.EXTRA_EMAIL, email);
                call.putExtra(Intent.EXTRA_SUBJECT, "Contact " + name);
                call.putExtra(Intent.EXTRA_TEXT, "Write your message here");
                call.setType("text/plain");
                startActivity(Intent.createChooser(call, "Send email:"));
            }
        });

        addressView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gm = Uri.parse("geo:0,0?q=101+"+address.replace(' ', '+'));
                Intent call = new Intent(Intent.ACTION_VIEW, gm);
                call.setPackage("com.google.android.apps.maps");
                startActivity(call);
            }
        });
    }
}
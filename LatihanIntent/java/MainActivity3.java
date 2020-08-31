package com.example.intentprojek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    public static String EXTRA_PEOPLE = "extra_people";
    People mPeople;
    TextView txtNama;
    TextView txtTtl;
    TextView txtJk;
    TextView txtAgama;
    TextView txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        txtNama = findViewById(R.id.isiNama);
        txtTtl = findViewById(R.id.isiTtl);
        txtJk = findViewById(R.id.isiJk);
        txtAgama = findViewById(R.id.isiAgama);
        txtEmail = findViewById(R.id.isiAlamat);

        mPeople = getIntent().getParcelableExtra(EXTRA_PEOPLE);
        txtNama.setText(mPeople.getNama());
        txtTtl.setText(mPeople.getTTL());
        txtJk.setText(mPeople.getJK());
        txtAgama.setText(mPeople.getAgama());
        txtEmail.setText(mPeople.getEmail());
    }

    public void kehome(View view){
        Intent home = new Intent(MainActivity3.this, MainActivity.class);
        home.putExtra(EXTRA_PEOPLE, mPeople);
        startActivity(home);
    }
}
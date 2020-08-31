package com.example.intentprojek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    People mPeople;
    EditText nama;
    EditText ttl;
    RadioGroup jk;
    EditText agama;
    EditText email;
    Button btnbuatData;
    Button btncancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nama = findViewById(R.id.nama);
        ttl = findViewById(R.id.ttl);
        jk = findViewById(R.id.jk);
        agama = findViewById(R.id.agama);
        email = findViewById(R.id.alamat);
        btnbuatData = findViewById(R.id.btn_buat);
        btnbuatData.setOnClickListener(this);
        btncancel = findViewById(R.id.btnCancel);
        btncancel.setOnClickListener(this);

        if (getIntent().getParcelableExtra(MainActivity3.EXTRA_PEOPLE) != null){
            mPeople = getIntent().getParcelableExtra(MainActivity3.EXTRA_PEOPLE);
            if (!mPeople.getNama().equals("No Data")){
                nama.setText(mPeople.getNama());
                ttl.setText(mPeople.getTTL());
                jkTerisi(mPeople.getJK());
                agama.setText(mPeople.getAgama());
                email.setText(mPeople.getEmail());

                btnbuatData.setText("EDIT IDENTITAS");
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_buat){
            mPeople = new People();
            mPeople.setNama(nama.getText().toString());
            mPeople.setTTL(ttl.getText().toString());
            mPeople.setJK(jenisKelamin());
            mPeople.setAgama(agama.getText().toString());
            mPeople.setEmail(email.getText().toString());

            Intent lihatData = new Intent(MainActivity2.this, MainActivity3.class);
            lihatData.putExtra(MainActivity3.EXTRA_PEOPLE, mPeople);
            startActivity(lihatData);
        }
        else if (v.getId() == R.id.btnCancel){
            Intent home = new Intent(MainActivity2.this, MainActivity.class);
            home.putExtra(MainActivity3.EXTRA_PEOPLE, mPeople);
            startActivity(home);
        }
    }

    public String jenisKelamin(){
        if (jk.getCheckedRadioButtonId() != 0){
            String value = "No Data";

            switch (jk.getCheckedRadioButtonId()){
                case R.id.jk_L:
                    value = "Laki-Laki";
                    break;

                case R.id.jk_P:
                    value = "Perempuan";
                    break;
            }

            return value;
        }

        return "No Data";
    }

    public void jkTerisi(String jkterisi){
        if (jkterisi.equals("Laki-Laki")){
            jk.check(R.id.jk_L);
        }
        else if (jkterisi.equals("Perempuan")){
            jk.check(R.id.jk_P);
        }
    }

}
package com.example.intentprojek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnBuatIdentitas;
    Button btnLihatIdentitas;
    Button btnkeWebsite;
    People mPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuatIdentitas = findViewById(R.id.btn_buat_identitas);
        btnBuatIdentitas.setOnClickListener(this);

        btnLihatIdentitas = findViewById(R.id.btn_lihat_identitas);
        btnLihatIdentitas.setOnClickListener(this);

        btnkeWebsite = findViewById(R.id.btn_my_website);
        btnkeWebsite.setOnClickListener(this);

        if (getIntent().getParcelableExtra(MainActivity3.EXTRA_PEOPLE) != null){
            mPeople = getIntent().getParcelableExtra(MainActivity3.EXTRA_PEOPLE);

            if(!mPeople.getNama().equals("No Data")){
                btnBuatIdentitas.setText("EDIT IDENTITAS");
            }

        } else {
            mPeople = new People("No Data");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_buat_identitas:
                Intent buat = new Intent(MainActivity.this, MainActivity2.class);
                buat.putExtra(MainActivity3.EXTRA_PEOPLE, mPeople);
                startActivity(buat);
                break;

            case R.id.btn_lihat_identitas:
                Intent lihat = new Intent(MainActivity.this, MainActivity3.class);
                lihat.putExtra(MainActivity3.EXTRA_PEOPLE, mPeople);
                startActivity(lihat);
                break;

            case R.id.btn_my_website:
                Intent myweb = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ramandrohend.blogspot.com"));
                startActivity(myweb);
                break;
        }
    }
}
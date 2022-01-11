package com.youngpark.parkbus;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                        Manifest.permission.NFC,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE},
                671);
    }

    public void open(View view) {
        startActivity(new Intent(MainActivity.this, BanlanceQueryActivity.class));
    }

    public void charge(View view) {
        startActivity(new Intent(MainActivity.this, ChargeActivity.class));
    }

    public void debit(View view) {
        startActivity(new Intent(MainActivity.this, DebitCardActivity.class));
    }
}

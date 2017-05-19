package com.lftechnology.barcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lftechnology.barcodereader.CameraActivity;

public class HomeActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1000;

    private TextView scannedIdTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        scannedIdTextView = (TextView) findViewById(R.id.textview_scanned_id);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(HomeActivity.this, CameraActivity.class), REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            scannedIdTextView.setText("Id: " + data.getStringExtra("code"));
            Log.e("DETECTED", data.getStringExtra("code"));
        }
    }
}

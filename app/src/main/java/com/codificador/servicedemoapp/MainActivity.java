package com.codificador.servicedemoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int PLAY_CODE = 1;
    public static final int PAUSE_CODE = 2;
    public static final int STOP_CODE = 3;
    public static final String SERVICE_EXTRA = "play_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonPlay).setOnClickListener(this);
        findViewById(R.id.buttonPause).setOnClickListener(this);
        findViewById(R.id.buttonStop).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this,PlayerService.class);
        switch (view.getId()){
            case R.id.buttonPlay:
                intent.putExtra(SERVICE_EXTRA,PLAY_CODE);
                startService(intent);
                break;
            case R.id.buttonPause:
                intent.putExtra(SERVICE_EXTRA, PAUSE_CODE);
                startService(intent);
                break;
            case R.id.buttonStop:
                intent.putExtra(SERVICE_EXTRA,STOP_CODE);
                startService(intent);
                break;
        }
    }
}

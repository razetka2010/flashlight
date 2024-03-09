package ru.da.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private FlachClass flachClass;
    private Button btnFlash;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFlash =  findViewById(R.id.btnFlash);
        flachClass = new FlachClass(this);
    }

    public void onClickFlash(View view) {
        if(flachClass.status()){
            flachClass.flashOff();
            btnFlash.setText("ON");
        } else {
            flachClass.flashOn();
            btnFlash.setText("OFF");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(flachClass.status()){
            flachClass.flashOff();
        }
    }
}
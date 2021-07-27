package com.example.sunshineweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunshineweather.R;

public class cityFinder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_finder);

        final EditText editText = findViewById(R.id.searchCity);
        ImageView backButton=findViewById(R.id.backbutton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //imeOptions ->actionGo
        // we did not create extra button for onclicklisteners ,, simply press enter key on phone keyboard

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                String newCity = editText.getText().toString();
                Intent i = new Intent(cityFinder.this, com.example.sunshineweatherapp.MainActivity.class);
                i.putExtra("city",newCity);

                startActivity(i);

                finish();

                return false;
            }
        });

    }
}
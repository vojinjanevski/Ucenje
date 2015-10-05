package com.example.janevski.vojin.ucenje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        Intent intent = getIntent();
        TextView textView = (TextView) findViewById(R.id.drugiTextView);
        textView.setText(intent.getStringExtra(MainActivity.STRING_KLJUC));
    }
}

package com.example.janevski.vojin.ucenje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    public static final String BROJ_KLJUC = "JEBENI BROJ";
    public static final String STRING_KLJUC = "JEBENI STRING";

    private TextView txtView;
    private EditText input;
    private int broj;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            broj = savedInstanceState.getInt(BROJ_KLJUC);
        }

        txtView = (TextView) findViewById(R.id.text_view);
        input = (EditText) findViewById(R.id.input_field);
        input.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                return;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                txtView.setText(input.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                return;
            }
        });
    }

    public void handleClick(View view)
    {
        Toast.makeText(getApplicationContext(), "" + broj++, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, ChildActivity.class);

        intent.putExtra(STRING_KLJUC, input.getText().toString());
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        outState.putInt(BROJ_KLJUC, broj);

        super.onSaveInstanceState(outState);
    }

}

package com.or.checkvalidation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.or.checkvalidationlibrary.CheckEditText;

public class MainActivity extends AppCompatActivity {
EditText one;
EditText two;
CheckEditText a;
Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = findViewById(R.id.one);
        btn = findViewById(R.id.btn);
        two = findViewById(R.id.two);

        a = new CheckEditText();
        a.add(one, CheckEditText.Type.SMALL_LETTERS);
        a.add(two, CheckEditText.Type.DATE);

        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String temp  =  a.checkForm()+"";
                      one.setText(temp);

                    }
                }
        );

    }
}
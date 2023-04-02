package com.example.android_tut_v72;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;

import java.util.Random;

public class TextPlay extends Activity {

    //declaring views variables
    Button chkcmd;
    ToggleButton click;
    EditText input;
    TextView display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Calling Method we defined in the bottom
        declaringVariables();

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (click.isChecked()) {
                    //if on then do this
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    //if off then do this
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                }
            }
        });

        chkcmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String check = input.getText().toString().trim();
                display.setText(check);

                if (check.contentEquals("left")) {
                    display.setGravity(Gravity.LEFT);
                } else if (check.contentEquals("center")) {
                    display.setGravity(Gravity.CENTER);
                } else if (check.contentEquals("right")) {
                    display.setGravity(Gravity.RIGHT);
                } else if (check.contentEquals("WTF")) {
                    //creating random digit variable
                    Random digit = new Random();
                    display.setText("WTF!!!");
                    display.setTextSize(digit.nextInt(50));
                    display.setTextColor(Color.rgb(digit.nextInt(265), digit.nextInt(265), digit.nextInt(265)));

                    //using switch and passing 3 random numbers i.e, 0,1,2 and cases are validated acr to digit var
                    switch (digit.nextInt(3)) {

                        case 0:
                            display.setGravity(Gravity.LEFT);
                            break;

                        case 1:
                            display.setGravity(Gravity.CENTER);
                            break;

                        case 2:
                            display.setGravity(Gravity.RIGHT);
                            break;


                    }


                } else {
                    display.setText("Invalid");
                    display.setTextColor(Color.GREEN);
                    display.setGravity(Gravity.CENTER);
                }


            }
        });


    }


    //Initializing variables in method Defination
    private void declaringVariables() {

        chkcmd = (Button) findViewById(R.id.br);
        click = (ToggleButton) findViewById(R.id.tgb);
        input = (EditText) findViewById(R.id.et);
        display = (TextView) findViewById(R.id.tv);

    }
}

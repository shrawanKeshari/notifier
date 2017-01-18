package com.example.sonu.bietapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class AggrateActivity extends AppCompatActivity {

    EditText et1, et2, et3, et4;
    TextView tv;
    CheckBox cb;
    int[] number;
    double sum, temp;
    String first, second, third, fourth, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        et4 = (EditText) findViewById(R.id.editText4);
        tv = (TextView) findViewById(R.id.textView2);
        cb = (CheckBox) findViewById(R.id.checkBox);

    }

    public void calculate_result(View view) {

        first = et1.getText().toString();
        second = et2.getText().toString();
        third = et3.getText().toString();
        fourth = et4.getText().toString();

        boolean checked = cb.isChecked();

        int flag = 1;
        int year = 0;
        int k = 1;
        number = new int[4];

        try {
            number[0] = Integer.parseInt(first);
        } catch (NumberFormatException e) {
            number[0] = 0;
        }

        try {
            number[1] = Integer.parseInt(second);
        } catch (NumberFormatException e) {
            number[1] = 0;
        }

        try {
            number[2] = Integer.parseInt(third);
        } catch (NumberFormatException e) {
            number[2] = 0;
        }

        try {
            number[3] = Integer.parseInt(fourth);
        } catch (NumberFormatException e) {
            number[3] = 0;
        }


        if(number[0] > 2000 || number[1] > 2000 || number[2] > 2000 || number[3] > 2000){
            flag = 0;
            message = "Enter the marks in range 0 to 2000";
            dialog(message);
        }

        if(checked){
            if(number[0] != 0){
                message = "Diploma Student's Enter the marks from 2nd year onwards";
                dialog(message);
                number[0] = 0;
                flag = 0;
            }
        }

        if(flag != 0){
            for (int i = 0; i < 4; i++) {
                if (number[i] != 0)
                    year++;
            }
            if(checked){
                year = year + 1;
                k = 2;
            }

            for (int j = k; j < 3; j++) {
                if (number[j] != 0) {
                    if (number[j - 1] == 0) {
                        year = -1;
                    }
                } else if (number[j] == 0) {
                    if (number[j + 1] != 0) {
                        year = -1;
                    }
                }
            }
        }

        if(flag == 1){
            temp = (number[0] * 0.25) + (number[1] * 0.50) + (number[2] * 0.75) + (number[3]);
        }else{
            temp = 0;
        }

        switch (year) {
            case 0:
                sum = 0;
                break;

            case 1:
                sum = temp / 5;
                break;

            case 2:
                if(!checked){
                    sum = temp / 15;
                }else {
                    sum = temp / 10;
                }
                break;

            case 3:
                if(!checked){
                    sum = temp / 30;
                }else {
                    sum = temp / 25;
                }
                break;

            case 4:
                if(!checked){
                    sum = temp / 50;
                }else {
                    sum = temp / 45;
                }
                break;

            case -1:
                sum = 0;
                message = "Can't skip the year" + "\n" + "Insufficient information"
                    + "\n" + "If Diploma (Lateral Entry) please click the Checkbox down";
                dialog(message);
                break;
        }

        DecimalFormat precision = new DecimalFormat("0.000000");

        tv.setText(precision.format(sum));
    }

    private void dialog(String message) {
        AlertDialog.Builder a1 = new AlertDialog.Builder(this);
        a1.setTitle("Alert Dialog");
        a1.setMessage(message);

        a1.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int button1) {
                        dialog.cancel();
                    }

                });
        AlertDialog alertDialog = a1.create();
        a1.show();
    }
}

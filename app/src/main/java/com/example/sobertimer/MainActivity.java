package com.example.sobertimer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {
    private TextView logo;
    private EditText quantity;
    private EditText weight;
    private EditText concentration;
    private TextView Result;
    private Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logo = (TextView)findViewById(R.id.logo);
        setContentView(R.layout.activity_main);
        quantity = (EditText)findViewById(R.id.ml);
        weight = (EditText)findViewById(R.id.weight);
        concentration = (EditText)findViewById(R.id.alcoholic);
        Result = (TextView)findViewById(R.id.Result);
        calculate = (Button)findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                //movement
                //[ 飲酒量計算公式 ]
                //喝下的c.c數或ml數 × (酒精度數/100) × 0.8(酒精比重) = 酒精攝取量(酒精重量)
                //肝臟分解酒精的速度是每小時約10毫升
                //血液酒精含量mg/100ml = 【飲酒量（ml）×酒精含量（%）×114】÷體重（公斤）
                String a = valueOf(concentration.getText());
                float b = Integer.parseInt(valueOf(quantity.getText()));
                float c = Integer.parseInt(valueOf(weight.getText()));
                int d = (int) ((Float.parseFloat(a)*b*114/100)/c)/10;
//                logo.setText(Float.toString(Float.parseFloat(a)));
                Result.setText((Float.toString(d)+" Hours"));
            }
        });
    }
}
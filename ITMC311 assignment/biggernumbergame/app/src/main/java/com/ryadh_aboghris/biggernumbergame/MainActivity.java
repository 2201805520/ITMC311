package com.ryadh_aboghris.biggernumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button a1,a2;
    TextView t1;
    int num1,num2,p=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a1=findViewById(R.id.a1);
        a2=findViewById(R.id.a2);
        t1=findViewById(R.id.p);

        roll();


        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                fun(num1,num2);
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fun(num2,num1);

            }
        });

    }
    void fun(int q1,int q2){
        if(q1>q2){

            p++;
            Toast.makeText(MainActivity.this, " correct", Toast.LENGTH_SHORT).show();

        }
        else{
            p--;
            Toast.makeText(MainActivity.this, " wrong", Toast.LENGTH_SHORT).show();

        }
        t1.setText("Points: "+p);
        roll();
    }
    void roll(){
        Random random=new Random();
        num1= random.nextInt(9);
        do{
            num2=random.nextInt(9);
        }while(num1==num2);
        a1.setText(num1+"");
        a2.setText(num2+"");
    }

}
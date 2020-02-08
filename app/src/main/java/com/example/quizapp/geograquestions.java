package com.example.quizapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class geograquestions extends AppCompatActivity {
    TextView tv;
    Button next, exit;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    int ct=0;
    public static int corect=0,gresit=0;
    String questions[] = {
            "1.Care este capitala Turciei?",
            "2.Care este cel mai aglomerat aeroport?",
            "3.Care este cea mai mare insulă din lume?",
            "4.Care este capitala Braziliei?",
            "5.Care este capitala Australiei?",
            "6.Care este cel mai lung râu din lume?",
            "7.Care este capitala Canadei?",
            "8.Care este capitala Emiratelor Arabe Unite? ",
            "9.În ce comitat este Castelul Leeds? ",
            "10.Care este capitala Marocului?"
    };
    String answers[] = {
            "Ankara","Atlanta International","Groenlanda","Brasilia","Canberra","Nile","Ottawa",
            "Abu Dhabi","Kent","Rabat"
    };
    String opt[] = {
            "Antalya","Istanbul","Bodrum","Ankara",
            "London Heathrow ","Beijing Capital International","Atlanta International","Dubai International",
            "Groenlanda","Madagascar","Borneo","Australia",
            "Salvador","Sao Paolo","Rio de Janeiro","Brasilia",
            "Sydney","Melbourne","Canberra","Brisbane",
            "Amazon","Nile","Yangtze","Mississippi",
            "Toronto", "Ottawa", "Vancouver","Montreal",
            "Abu Dhabi","Sharm el Sheikh","Sharjah","Dubai",
            "Shropshire","Berkshire","Yorkshire","Kent",
            "Fes","Casablanca","Rabat","Marrakesh"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geograquestions);

        final TextView score = findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");
        if (name.equals(""))
            textView.setText("Hei User");
        else
            textView.setText("Hei " + name);

        next = findViewById(R.id.button3);
        exit = findViewById(R.id.buttonquit);
        tv = findViewById(R.id.tvque);
        radio_g = findViewById(R.id.answersgrp);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        tv.setText(questions[ct]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio_g.getCheckedRadioButtonId()==-1) {
                    Toast.makeText(getApplicationContext(), "Selecteaza o varianta", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton noAnswer =  findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = noAnswer.getText().toString();
                if(ansText.equals(answers[ct])) {
                    corect++;
                    Toast.makeText(getApplicationContext(), "Corect", Toast.LENGTH_SHORT).show();
                }
                else {
                    gresit++;
                    Toast.makeText(getApplicationContext(), "Gresit", Toast.LENGTH_SHORT).show();
                }
                ct++;
                if (score != null)
                    score.setText(""+corect);
                if(ct<questions.length) {
                    tv.setText(questions[ct]);
                    rb1.setText(opt[ct*4]);
                    rb2.setText(opt[ct*4 +1]);
                    rb3.setText(opt[ct*4 +2]);
                    rb4.setText(opt[ct*4 +3]);
                }
                else {
                    startActivity(new Intent(getApplicationContext(),result.class));
                }
                radio_g.clearCheck();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),result.class);
                startActivity(intent);
            }
        });
    }

}
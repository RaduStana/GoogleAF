package com.example.quizapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {
    TextView tv, tv2, tv3;
    Button btnRestart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = findViewById(R.id.tvres);
        tv2 = findViewById(R.id.tvres2);
        btnRestart = findViewById(R.id.btnRestart);

        StringBuffer sb = new StringBuffer();
        sb.append("Raspunsuri corecte: " + geograquestions.corect + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("Raspunsuri gresite: " + geograquestions.gresit + "\n");
        tv.setText(sb);
        tv2.setText(sb2);
        geograquestions.corect=0;
        geograquestions.gresit=0;
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

}

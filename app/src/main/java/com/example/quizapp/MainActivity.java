package com.example.quizapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startbutton = findViewById(R.id.button);
        final EditText nametext = findViewById(R.id.editName);

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String name = nametext.getText().toString();
                Intent intent = new Intent(getApplicationContext(), geograquestions.class);
                intent.putExtra("myname", name);
                startActivity(intent);
        }
        });
    }
}

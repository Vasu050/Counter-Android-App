package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.activity.EdgeToEdge;

public class MainActivity extends AppCompatActivity {
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button button = findViewById(R.id.button);
        TextView btnCount =findViewById(R.id.btnCount);
        Button resetBtn = findViewById(R.id.resetBtn);
        // Set click listener
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                counter++;
                btnCount.setText(Integer.toString(counter));

            }
        });
        resetBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter=0;
                btnCount.setText(Integer.toString(counter));

            }
        }));
    }
}

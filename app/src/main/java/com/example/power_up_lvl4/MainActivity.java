package com.example.power_up_lvl4;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    Button B1 , B2 ,B3;
    TextView T1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            INtz ();
            return insets;
        });


    }
    private  void INtz ()
    {
        B1 = findViewById(R.id.button);
        B2 = findViewById(R.id.button2);
        B3 = findViewById(R.id.button3);
        T1 = findViewById(R.id.textView);

        B1.setOnClickListener(view -> edti());
        B2.setOnClickListener(view -> Color_ss());
        B3.setOnClickListener(view ->  Go());

    }
    private  void edti()
    {
        T1.setText("MXM");

    }
    private  void Color_ss()
    {
   T1.setTextColor(Color.parseColor("#FFFFFFFF"));
    }
    private  void Go()
    {
        Intent intent = new Intent(this, add.class);
        startActivity(intent);
    }
}
package com.doneed.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.doneed.R;

public class SecondAppIntro extends AppCompatActivity {
    TextView sin;
    LinearLayout circle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_app_intro);

        circle = (LinearLayout) findViewById(R.id.circle);
        sin = (TextView) findViewById(R.id.sin);

        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(SecondAppIntro.this,signup.class);
                startActivity(it);

            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(SecondAppIntro.this,signin.class);
                startActivity(it);
            }
        });

    }
}

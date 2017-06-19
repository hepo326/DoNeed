package com.doneed.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.doneed.R;

public class signin extends AppCompatActivity {

    ImageView sback;
    com.doneed.customfonts.MyTextView sIN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        sback = (ImageView)findViewById(R.id.sinb);
        sback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(signin.this,SecondAppIntro.class);
                startActivity(it);
            }
        });


        sIN=(com.doneed.customfonts.MyTextView)findViewById(R.id.sinIN);
        sIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(signin.this,CharityMainView.class);
                startActivity(it);
            }
        });

    }


}

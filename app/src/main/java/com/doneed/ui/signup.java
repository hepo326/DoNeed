package com.doneed.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.doneed.R;

public class signup extends AppCompatActivity
{
    ImageView sbackImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        sbackImg = (ImageView)findViewById(R.id.sback);
        sbackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(signup.this, SecondAppIntro.class);
                startActivity(it);

            }
        });
    }
}

package com.vind.www.rec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    Button JoinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        JoinBtn = (Button) findViewById(R.id.JoinBtn);

        JoinBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Toast.makeText(getApplicationContext(), "Click to Joinbtn.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
            }
        });

    }
}

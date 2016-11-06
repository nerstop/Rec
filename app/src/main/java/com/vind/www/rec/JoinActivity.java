package com.vind.www.rec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JoinActivity extends AppCompatActivity {

    Button ConfirmBtn;
    EditText NameEditText, PhoneEditText, BirthEditText, MajorEditText, StdIDEditText;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        ConfirmBtn = (Button) findViewById(R.id.ConfirmBtn);

        NameEditText  = (EditText) findViewById(R.id.NameEditText);
        PhoneEditText = (EditText) findViewById(R.id.PhoneEditText);
        BirthEditText = (EditText) findViewById(R.id.BirthEditText);
        MajorEditText = (EditText) findViewById(R.id.MajorEditText);
        StdIDEditText = (EditText) findViewById(R.id.StdIDEditText);


        ConfirmBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                data = NameEditText.getText().toString() + "\n";
                //data += PhoneEditText.getText().toString() + "\n";
                //data += BirthEditText.getText().toString() + "\n";
                //data += MajorEditText.getText().toString() + "\n";
                //data += StdIDEditText.getText().toString();

                Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
            }
        });

    }
}

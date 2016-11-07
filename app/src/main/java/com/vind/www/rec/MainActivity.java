package com.vind.www.rec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String birth = intent.getStringExtra("birth");
        String major = intent.getStringExtra("major");
        String stdID = intent.getStringExtra("stdID");


        Toast.makeText(getApplicationContext(), name + ", " + phone + ", " + birth + ", " + major + ", " + stdID + ", " , Toast.LENGTH_LONG).show();
    }
}

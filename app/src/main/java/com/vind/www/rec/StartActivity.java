package com.vind.www.rec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StartActivity extends AppCompatActivity {

    Button JoinBtn, LoginBtn;
    EditText LoginID;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    //private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference databaseReference = firebaseDatabase.getReference("userInfo"); //읽기전용


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        JoinBtn = (Button) findViewById(R.id.JoinBtn);
        LoginBtn = (Button) findViewById(R.id.LoginBtn);

        JoinBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Toast.makeText(getApplicationContext(), "Click to Joinbtn.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
            }
        });

        LoginBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                LoginID = (EditText)findViewById(R.id.IDEditText);
                    databaseReference.orderByChild("name").addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                            UserInfo userInfo = dataSnapshot.getValue(UserInfo.class);
                            if (userInfo.getName().equals(LoginID.getText().toString())) {
                                Toast.makeText(getApplicationContext(), dataSnapshot.getKey() + " was " + userInfo.getName(), Toast.LENGTH_SHORT).show();
                                //System.out.println(dataSnapshot.getKey() + " was " + userInfo.height + " meters tall.");
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.putExtra("name", userInfo.getName());
                                intent.putExtra("phone", userInfo.getPhone());
                                intent.putExtra("birth", userInfo.getBirth());
                                intent.putExtra("major", userInfo.getMajor());
                                intent.putExtra("stdID", userInfo.getStdID());
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                        }

                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {
                        }

                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
                        }
                    });
//                LoginID = (EditText)findViewById(R.id.IDEditText);
//                //Toast.makeText(getApplicationContext(), "Click to Joinbtn.", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                intent.putExtra("ID", LoginID.getText().toString() );
//                startActivity(intent);
            }
        });

    }
}

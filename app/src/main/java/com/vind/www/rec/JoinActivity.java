package com.vind.www.rec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class JoinActivity extends AppCompatActivity {

    Button ConfirmBtn;
    EditText NameEditText, PhoneEditText, BirthEditText, MajorEditText, StdIDEditText;
    String data;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();


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

                String name, phone, birth, major, stdID;
                name = NameEditText.getText().toString();
                phone = PhoneEditText.getText().toString();
                birth = BirthEditText.getText().toString();
                major = MajorEditText.getText().toString();
                stdID = StdIDEditText.getText().toString();
                if(name.equals("")) {
                    Toast.makeText(getApplicationContext(), "insert name", Toast.LENGTH_LONG).show();
                }
                else if(phone.equals("")) {
                    Toast.makeText(getApplicationContext(), "insert phone", Toast.LENGTH_LONG).show();
                }
                else if(birth.equals("")) {
                    Toast.makeText(getApplicationContext(), "insert birthday", Toast.LENGTH_LONG).show();
                }
                else if(major.equals("")) {
                    Toast.makeText(getApplicationContext(), "insert major", Toast.LENGTH_LONG).show();
                }
                else if(stdID.equals("")) {
                    Toast.makeText(getApplicationContext(), "insert student ID", Toast.LENGTH_LONG).show();
                }
                else {
                    //Toast.makeText(getApplicationContext(), "Clear", Toast.LENGTH_LONG).show();
                    UserInfo userInfo = new UserInfo(name, phone, birth, major, stdID);  // 유저 이름과 메세지로 chatData 만들기
                    databaseReference.child("userInfo").push().setValue(userInfo);  // 기본 database 하위 message라는 child에 chatData를 list로 만들기
                    Toast.makeText(getApplicationContext(), "Finish", Toast.LENGTH_LONG).show();
                    //editText.setText("");
                }



            }
        });

    }
}

package com.example.a1605476.registrationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name, address;
    TextView text;
    Button btn, savebtn;
    FirebaseAuth firebaseAuth;
    DatabaseReference firebaseDatabase;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        text = (TextView) findViewById(R.id.text);
        btn = (Button) findViewById(R.id.LogOutbtn);
        name = (EditText) findViewById(R.id.name);
        address= (EditText) findViewById(R.id.address);
        savebtn= (Button) findViewById(R.id.save);
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        firebaseDatabase = FirebaseDatabase.getInstance().getReference();

        text.setText(user.getEmail());

        if (firebaseAuth.getCurrentUser() == null) {
            Intent intent = new Intent(this, LogInActivity.class);
            startActivity(intent);
        }
        btn.setOnClickListener(this);

        savebtn.setOnClickListener(this);
    }

    public void save()
    {
        String nameString=name.getText().toString();
        String addressString=address.getText().toString();
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        UserInformtion info=new UserInformtion(nameString,addressString);
        firebaseDatabase.child(user.getUid()).setValue(info);
        Toast.makeText(this,"Saved successfully",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        if (v == btn) {
            firebaseAuth.signOut();
            finish();
            Intent intent = new Intent(this, LogInActivity.class);
            startActivity(intent);

        }
        if (v == savebtn) {
            save();
        }
    }
}
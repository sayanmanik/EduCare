package com.example.a1605476.registrationapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText nameText,emailText,passWordText;
    private ProgressDialog progressDialog;
    private AppCompatButton reg,LinkToLogIn;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText= (TextInputEditText) findViewById(R.id.name);
        emailText= (TextInputEditText) findViewById(R.id.email);
        passWordText= (TextInputEditText) findViewById(R.id.password);
        progressDialog=new ProgressDialog(this);
        reg= (AppCompatButton) findViewById(R.id.btnRegister);
        LinkToLogIn= (AppCompatButton) findViewById(R.id.btnLinkToLoginScreen);
        firebaseAuth=FirebaseAuth.getInstance();

        if(isConnected())
        {
            Toast.makeText(this,"Connected",Toast.LENGTH_LONG).show();
        }

        else
        {
            Toast.makeText(this,"Not connected to internet",Toast.LENGTH_LONG).show();
        }

        if(firebaseAuth.getCurrentUser()!=null)
        {
            Intent intent=new Intent(this,CourseActivity.class);
            startActivity(intent);
        }
        reg.setOnClickListener(this);

        LinkToLogIn.setOnClickListener(this);

    }

    public void registerUser()
    {
        String name=nameText.getText().toString().trim();
        String email=emailText.getText().toString().trim();
        String password=passWordText.getText().toString().trim();

        if(TextUtils.isEmpty(name))
        {
            Toast.makeText(this, "name is needed", Toast.LENGTH_SHORT).show();
        }


        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "email is needed", Toast.LENGTH_SHORT).show();
        }


        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "password is needed", Toast.LENGTH_SHORT).show();
        }

        if (!TextUtils.isEmpty(name)||!TextUtils.isEmpty(email)||!TextUtils.isEmpty(password))
        {
            progressDialog.setMessage("Registering...");
            progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                progressDialog.dismiss();
                if(task.isSuccessful())
                {
                        sendConfirmation();
                        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(intent);
                }

                else
                {
                    Toast.makeText(MainActivity.this,"Registration Unsuccessful",Toast.LENGTH_SHORT).show();
                    progressDialog.hide();

                }
            }
        });
        }

    }

   private void  sendConfirmation()
   {
       FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
       if(user!=null)
       {
           user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
               @Override
               public void onComplete(@NonNull Task<Void> task) {
                  if(task.isSuccessful())
                  {
                      Toast.makeText(getApplicationContext(),"Check your mail for confirmation",Toast.LENGTH_SHORT).show();
                      FirebaseAuth.getInstance().signOut();

                  }
               }
           });
       }
   }

    @Override
    public void onClick(View v) {
        if(v==reg)
        {
            registerUser();
        }

        if(v==LinkToLogIn)
        {
            Intent intent=new Intent(this,LogInActivity.class);
            startActivity(intent);
        }
    }

    private boolean isConnected() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }
}
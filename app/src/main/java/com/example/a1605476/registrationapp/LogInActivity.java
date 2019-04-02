package com.example.a1605476.registrationapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener{

    TextInputEditText Email,Password;
    AppCompatButton btnLogIn,btnRegister;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Email= (TextInputEditText) findViewById(R.id.email);
        Password= (TextInputEditText) findViewById(R.id.password);

        progressDialog=new ProgressDialog(this);

        btnLogIn= (AppCompatButton) findViewById(R.id.btnLogin);
        btnRegister= (AppCompatButton) findViewById(R.id.btnLinkToRegisterScreen);

        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null)
        {
            finish();
            Intent intent=new Intent(this,ProfileActivity.class);
            startActivity(intent);
        }

        if(isConnected())
        {
            Toast.makeText(this,"Connected",Toast.LENGTH_LONG).show();
        }

        else
        {
            Toast.makeText(this,"Not connected to internet",Toast.LENGTH_LONG).show();
        }
        btnLogIn.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    private void login()
    {
        String email=Email.getText().toString().trim();
        String password=Password.getText().toString().trim();

        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "email is needed", Toast.LENGTH_SHORT).show();
        }


        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "password is needed", Toast.LENGTH_SHORT).show();
        }

        if(!TextUtils.isEmpty(email)||!TextUtils.isEmpty(password))
        {
            progressDialog.setMessage("Logging In...");
            progressDialog.show();
            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();
                        if(task.isSuccessful())
                        {
                            finish();
                            Intent intent=new Intent(getApplicationContext(),CourseActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(LogInActivity.this,"Check your email or password",Toast.LENGTH_SHORT).show();
                        }
                }
            });

        }

    }
    @Override
    public void onClick(View v) {
        if(v==btnLogIn)
        {
            login();
        }
        if(v==btnRegister)
        {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }

    private boolean isConnected()
    {
        ConnectivityManager manager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info=manager.getActiveNetworkInfo();
        return info!=null&&info.isConnected();
    }

}

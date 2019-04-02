package com.example.a1605476.registrationapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1605476.registrationapp.FragmentDirectory.Quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Play extends AppCompatActivity {
    Intent intent;
    Questions questions=new Questions();
    TextView msqueno;
    Button option1;
    Button option2;
    Button option3;
    Button option4;
    ImageView exit;
    ImageView next;
    TextView msco;
    TextView mquestion;
    int mscore=0;
    String manswer;
    Random random=new Random();
    int c=1;
    int a;
    int l=0;
    int getIndex;
    ArrayList<Integer> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        list=new ArrayList<Integer>();
        intent=getIntent();
        int getCount=intent.getIntExtra("z",0);
        getIndex=intent.getIntExtra("e",0);
        int i;
        for(i=0;i<4;i++)
            list.add(i);
        Collections.shuffle(list);
        a=list.get(l);
        msco=(TextView)findViewById(R.id.textview);
        msqueno=(TextView)findViewById(R.id.textview2);
        mquestion=(TextView)findViewById(R.id.textview3);
        option1=(Button)findViewById(R.id.button2);
        option2=(Button)findViewById(R.id.button3);
        option3=(Button)findViewById(R.id.button4);
        option4=(Button)findViewById(R.id.button5);
        exit=(ImageView)findViewById(R.id.imageview1);
        next=(ImageView)findViewById(R.id.imageview2);
        mquestion.setText(questions.mquestion(a,getIndex));
        option1.setText(questions.moption1(a,getIndex));
        option2.setText(questions.moption2(a,getIndex));
        option3.setText(questions.moption3(a,getIndex));
        option4.setText(questions.moption4(a,getIndex));
        manswer=questions.getanswer(a,getIndex);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(option1.getText()==manswer)
                {mscore=mscore+1;
                    myscore();
                    Toast.makeText(getApplicationContext(), "correct answer", Toast.LENGTH_SHORT).show();
                    updateque();
                }
                else{
                    Toast.makeText(getApplicationContext(), "incorrect answer", Toast.LENGTH_SHORT).show();
                    updateque();}
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(option2.getText()==manswer)
                {mscore=mscore+1;
                    myscore();
                    Toast.makeText(getApplicationContext(), "correct answer", Toast.LENGTH_SHORT).show();
                    updateque();
                }
                else{
                    Toast.makeText(getApplicationContext(), "incorrect answer", Toast.LENGTH_SHORT).show();
                    updateque();}
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(option3.getText()==manswer)
                {
                    mscore=mscore+1;
                    myscore();
                    Toast.makeText(getApplicationContext(), "correct answer", Toast.LENGTH_SHORT).show();
                    updateque();
                }
                else{
                    Toast.makeText(getApplicationContext(), "incorrect answer", Toast.LENGTH_SHORT).show();
                    updateque();}
            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option4.getText()==manswer)
                {
                    mscore=mscore+1;
                    myscore();
                    Toast.makeText(getApplicationContext(), "correct answer", Toast.LENGTH_SHORT).show();
                    updateque();
                }
                else{
                    Toast.makeText(getApplicationContext(), "incorrect answer", Toast.LENGTH_SHORT).show();
                    updateque();}
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                intent = new Intent(Play.this,LastActivity.class);
                startActivity(intent);

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateque();
            }
        });
    }
    public void myscore()
    {
        msco.setText(""+(mscore*10));
    }
    public void updateque()
    {
        if(c>3)
        {

        }
        else{
            c++;
            l++;
            a=list.get(l);
            msqueno.setText("0"+c);
            mquestion.setText(questions.mquestion(a,getIndex));
            option1.setText(questions.moption1(a,getIndex));
            option2.setText(questions.moption2(a,getIndex));
            option3.setText(questions.moption3(a,getIndex));
            option4.setText(questions.moption4(a,getIndex));
            manswer=questions.getanswer(a,getIndex);}


    }
}

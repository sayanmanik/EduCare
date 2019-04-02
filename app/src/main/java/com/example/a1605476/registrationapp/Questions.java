package com.example.a1605476.registrationapp;

public class Questions {
    String mque[][]={{"What is C ?","Who Invented C language ?","Who is known as the father of Computer ?","Name a language Related to C?"},
            {"What is C++ ?","Who is the Founder of C++ ?","Which Of the following is OOP ?","OOP fullform ?"}};
    String option[][][]={{{"Language","alphabet","only a","none"},
            {"st louis","d krieg","Dennis Ritchie","Ken Thomson"},
            {"Charles Babbage","Alan Turing","Pythagoras","Einstein"},
            {"Fortran","Cobol","C++","None"}},
                   {{"Language","Alphabet","Database","None"},
                    {"Bjarne Stroustrup","Herb Sutter","James Gosling","Scott Meyers"},
                    {"C","Fortran","Cobol","C++"},
                    {"Object Oriented Programming","Object Oriented Platform","Orthodox Oriented Programming","None"}}};
    String answer[][]={{"Language","Dennis Ritchie","Charles Babbage","C++"},
            {"Language","Bjarne Stroustrup","C++","Object Oriented Programming"}};

    public String mquestion(int a,int getIndex)
    {
        String question=mque[getIndex][a];
        return question;
    }

    public String moption1(int a,int getIndex)
    {
        String option1=option[getIndex][a][0];
        return option1;
    }
    public String moption2(int a,int getIndex)
    {
        String option2=option[getIndex][a][1];
        return option2;
    }
    public String moption3(int a,int getIndex)
    {
        String option3=option[getIndex][a][2];
        return option3;
    }
    public String moption4(int a,int getIndex)
    {
        String option4=option[getIndex][a][3];
        return option4;
    }
    public String getanswer(int a,int getIndex)
    {
        String manswer1=answer[getIndex][a];
        return manswer1;
    }
}

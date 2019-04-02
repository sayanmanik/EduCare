package com.example.a1605476.registrationapp.Description;

/**
 * Created by 1605476 on 29-Mar-18.
 */

public class C_Plus_Plus_Description
{
    String id;
    String name;

    public C_Plus_Plus_Description(String name,String id)
    {
        this.id=id;
        this.name=name;
    }

    public static C_Plus_Plus_Description[] c_plus_plus_description={new C_Plus_Plus_Description("1","Introduction to OOP"),
            new C_Plus_Plus_Description("2","C++ Beginning"),
            new C_Plus_Plus_Description("3","Class")};

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void putName(String course_name)
    {
        name=course_name;
    }

    public void putId(String course_id)
    {
        id=course_id;
    }
}

package com.example.a1605476.registrationapp.Description;

/**
 * Created by 1605476 on 29-Mar-18.
 */

public class C_Description
{
    static String id;
    static String name;

    public C_Description(String name,String id)
    {
        this.id=id;
        this.name=name;
    }

    public static C_Description[] c_description={new C_Description("1","Introduction"),
            new C_Description("2","Loop"),
            new C_Description("3","Function")};

    public  static String getId()
    {
        return id;
    }

    public static String getName()
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

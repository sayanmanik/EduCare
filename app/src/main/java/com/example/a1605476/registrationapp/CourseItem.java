package com.example.a1605476.registrationapp;

/**
 * Created by 1605476 on 28-Mar-18.
 */

public class CourseItem
{
    static String name;
    static String image;

    public CourseItem(String name,String image)
    {
        this.name=name;
        this.image=image;
    }

    public static CourseItem[] course= {new CourseItem("C",String.valueOf(R.mipmap.c)),
        new CourseItem("C++",String.valueOf(R.mipmap.c_plus_plus))};

    public static String getName()
    {
        return name;
    }

    public static String getImage()
    {
        return image;
    }

    public static  void putName(String description)
    {
        name=description;
    }

    public static void putImage(String imageDescription)
    {
        image=imageDescription;
    }
}

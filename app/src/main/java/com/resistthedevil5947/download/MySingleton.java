package com.resistthedevil5947.download;

import android.content.Context;

public class MySingleton {

    private static MySingleton single_instance = null;

    // variable of type String
    public String s;

    // private constructor restricted to this class itself
    private MySingleton()
    {
        s = "Hello I am a string part of Singleton class";
    }

    // static method to create instance of Singleton class
    public static MySingleton getInstance(Context context)
    {
        if (single_instance == null)
            single_instance = new MySingleton();

        return single_instance;
    }
}

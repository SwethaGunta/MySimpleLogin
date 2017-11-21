package com.example.mysimplelogin;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public  enum Regexes {
    NAME("^[A-Za-z]+$"),
    PASSWORD("^[A-Za-z0-9!@#$%^&*.()_`/~/-/+={}]{8,15}+$"),
    PHONE("^[0-9]{10,12}+$"),
    EMAIL("^[A-Za-z0-9!@#$%^&*.()_`/~/-/+={}]+@[a-z]+.[a-z]{2,3}+$"),
    PINCODE("^[0-9]{6}$");
    String regex_value;

    Regexes(String s) {
        this.regex_value = s;
    }
    String getvalue()
    {
        return regex_value;
    }

}

//ADD ENUM
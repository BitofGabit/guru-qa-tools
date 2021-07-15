package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class StudentDataUtils {

    public static String fakeAddress(){
        Faker fake = new Faker(Locale.ENGLISH);
        return fake.address().fullAddress();
    }

}

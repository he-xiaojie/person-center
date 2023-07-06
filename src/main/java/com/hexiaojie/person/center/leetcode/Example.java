package com.hexiaojie.person.center.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Example {
    String ex = new String("good");
    char[] ch = {'a','b','c'};

    public static void main(String[] args) {
        Example example = new Example();
        example.change(example.ex, example.ch);
        System.out.print(example.ex + " and ");
        System.out.print(example.ch);
    }

    public void change(String str, char ch[]){

        Map<String,String> map = new HashMap<>();
        map.put("a","a");

        str = "test ok";
        ch[0] = 'g';
    }
}

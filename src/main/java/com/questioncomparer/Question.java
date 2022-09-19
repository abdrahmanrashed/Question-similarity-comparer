package com.questioncomparer;

import java.util.ArrayList;
import java.util.Arrays;

public class Question{

    private final String q;
    private ArrayList<String> w = new ArrayList<String>();

    // creates question from string
    Question(String s){
        q = s;
        w.addAll(Arrays.asList(q.split(" ")));
    }
    @Override
    public String toString() {
        return q;
    }
}
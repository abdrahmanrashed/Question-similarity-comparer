package com.questioncomparer;

import java.io.*;
import java.util.*;

public class Reader {

    // reads from database
    public static void readQuestions(){

        File f = new File("questions.txt");
        try{
            if(!f.exists()) f.createNewFile();
            Scanner sc = new Scanner(f);

            while(sc.hasNextLine()){
                Question q = new Question(sc.nextLine());
                Core.Questions.add(q);
            }
            sc.close();
        }
        catch(IOException e){
            Core.debug(e);
        }
    }
}

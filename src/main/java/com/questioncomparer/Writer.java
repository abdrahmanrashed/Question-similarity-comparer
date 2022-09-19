package com.questioncomparer;
import java.io.*;
import java.nio.file.*;

public class Writer {

    // writes to database
    public static void writeQuestions(){

        File f = new File("questions.txt");
        if(f.exists()) f.delete();
        try{
            f.createNewFile();

            FileWriter w = new FileWriter(f);

            for(var i : Core.Questions){
                w.write(i.toString());
                w.write("\n");
            }
            w.flush();
            w.close();
        }
        catch (IOException e){
            Core.debug(e);
        }
    }
}

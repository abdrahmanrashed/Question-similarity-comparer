package com.questioncomparer;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;
import java.util.*;
import java.io.*;

public class Core extends Application {
    static ArrayList<Question> Questions = new ArrayList<Question>();
    public static void main(String[] args){
        // reads from the database
        Reader.readQuestions();

        // application loader
        launch();

        // writes to the database
        Writer.writeQuestions();

    }
    // debugger
    static void debug(Exception e){
        System.out.println(e.getStackTrace());
    }
    // application starter
    @Override
    public void start(Stage prim) throws Exception {
        FXMLLoader ldr = new FXMLLoader(Core.class.getResource("hello-view.fxml"));
        try{
            Scene scn = new Scene(ldr.load());
            prim.setTitle("Question Comparer");
            prim.setScene(scn);
            prim.show();
        }
        catch(Exception e){
            Core.debug(e);
        }
    }
}
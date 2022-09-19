package com.questioncomparer;

import javafx.beans.value.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import java.util.*;

public class Control {
    public Button addQ, remQ, relQ, savQ, refQ, selQ1, selQ2, cmpQ;
    public TextField insQ;
    public ListView<String> ersQ;
    public Label insQ1, insQ2, labQ3;

    // adds question to database
    public void insert(){
        String s = insQ.getText();
        if(!(s.isEmpty() || s.equals("Enter a Question:") || ersQ.getItems().contains(s))) ersQ.getItems().add(insQ.getText());
    }

    // loads the database from the previously saved state
    public void reload(){
        var arr = ersQ.getItems();
        arr.clear();
        for(var i : Core.Questions){
            arr.add(i.toString());
        }
        Collections.sort(arr.subList(0, arr.size()));
    }

    // removes question from database
    public void erase(){
        ersQ.getItems().remove(ersQ.getSelectionModel().getSelectedItem());
    }

    // saves the current database
    public void save(){
        Core.Questions.clear();
        for(var i : ersQ.getItems()){
            Core.Questions.add(new Question(i));
        }
    }

    // refreshes database
    public void fresh(){
        var arr = ersQ.getItems();
        Collections.sort(arr.subList(0, arr.size()));
    }
    public void cseQ1(){
        insQ1.setText(ersQ.getSelectionModel().getSelectedItem());
    }
    public void cseQ2(){
        insQ2.setText(ersQ.getSelectionModel().getSelectedItem());
    }
    public void result(){
        String a = insQ1.getText(), b = insQ2.getText();
        if(!(a == null || b == null || Objects.equals(a, "Select the 1st question:") || Objects.equals(b, "Select the 2nd question:"))){
            labQ3.setText(String.format("%.2f%%", Comparator.similarity(a, b)));
        }
        else labQ3.setText("Result appears here.");
    }
}

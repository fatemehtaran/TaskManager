package com.taran.taskmanager;

import android.widget.CheckBox;

import java.util.ArrayList;

public class Task {

    private String name;
    ArrayList<String> work = new ArrayList<>();
    CheckBox checkBox;

    public Task(String name, ArrayList<String> work , CheckBox checkBox) {
        this.name = name;
        this.work = work;
       // this.checkBox = checkBox;
    }

    public Task(String toString, ArrayList<String> strings) {

    }

    //public CheckBox getCheckBox() {
    //    return checkBox;
   // }

    public String getName() {
        return name;
    }

    public ArrayList<String> getWork() {
        return work;
    }
}

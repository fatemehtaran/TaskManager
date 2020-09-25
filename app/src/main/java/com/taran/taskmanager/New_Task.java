package com.taran.taskmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class New_Task {

    private Context mContext;

    public New_Task(Context Context){

        mContext = Context;
    }

    public void saveTask (Task task) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        HashSet itemHashSet = new HashSet(Arrays.asList(task.getWork()));

        editor.putStringSet(task.getName(), itemHashSet);

        editor.putBoolean(key, isChecked);

        editor.apply();

    }




    public ArrayList<Task> retrieveTasks(){

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        Map< String , ? > data = sharedPreferences.getAll();

        ArrayList<Task> tasks = new ArrayList<>();

        for (Map.Entry<String , ?> entry : data.entrySet()){

            Task task = new Task(entry.getKey(), new ArrayList<String>((HashSet) entry.getValue()));

         //   return sharedPreferences.getBoolean(key, false);


            tasks.add(task);

        }

        return tasks;

    }
}


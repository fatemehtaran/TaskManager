package com.taran.taskmanager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.WorkSource;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    FloatingActionButton fab;

    private New_Task new_task = new New_Task(this);
    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ArrayList<Task> tasks = new_task.retrieveTasks();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new TaskAdapter(tasks));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addTaskDialog();
            }
        });

    }





    



    private void addTaskDialog() {

        String alertTitle = "Enter Your Task Name";
        String PositiveButtonTitle = "Create";
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        final EditText taskEditText = new EditText(this);
        taskEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        alertBuilder.setIcon(R.drawable.download);

        alertBuilder.setTitle(alertTitle);
        alertBuilder.setView(taskEditText);

        alertBuilder.setPositiveButton(PositiveButtonTitle, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Task task = new Task(taskEditText.getText().toString(), new ArrayList<String>());
                new_task.saveTask(task);

                TaskAdapter taskAdapter = (TaskAdapter) recyclerView.getAdapter();
                taskAdapter.addTask(task);


                dialogInterface.dismiss();
            }

        });


        alertBuilder.show();


        //Search




    }




}






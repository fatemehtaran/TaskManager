package com.taran.taskmanager;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    private  ArrayList<Task> tasks;


    public TaskAdapter(ArrayList<Task> tasks) {
        this.tasks = tasks;


    }



    //search
    public void filteredList(ArrayList<Task> filterList) {
        tasks = filterList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.new_task , parent, false );
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return new  MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder , final int position) {

        holder.getTxtTask().setText(tasks.get(position).getName());

    }


    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void addTask(Task task) {

        tasks.add(task);

        notifyItemInserted(tasks.size() - 1);
    }







    //new class MyViewHolder = categoryViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtTask;
        CheckBox checkBox;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            txtTask = itemView.findViewById(R.id.txtTask);
            checkBox = itemView.findViewById(R.id.checkBox);

        }

        public TextView getTxtTask() {
            return txtTask;
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }
    }

}

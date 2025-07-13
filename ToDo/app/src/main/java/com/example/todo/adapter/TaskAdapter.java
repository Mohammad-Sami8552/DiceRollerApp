package com.example.todo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo.R;
import com.example.todo.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    private List<Task> tasks = new ArrayList<>();
    private final TaskListener listener;

    public interface TaskListener {
        void onTaskCheckedChanged(Task task, boolean isChecked);
        void onTaskSwiped(Task task);
    }

    public TaskAdapter(TaskListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.bind(task);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {
        private final CheckBox checkBox;
        private final TextView titleText;

        TaskViewHolder(View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkbox_task);
            titleText = itemView.findViewById(R.id.text_task_title);
        }

        void bind(Task task) {
            titleText.setText(task.getTitle());
            checkBox.setChecked(task.isCompleted());
            checkBox.setOnCheckedChangeListener((buttonView, isChecked) ->
                    listener.onTaskCheckedChanged(task, isChecked));
        }
    }
} 
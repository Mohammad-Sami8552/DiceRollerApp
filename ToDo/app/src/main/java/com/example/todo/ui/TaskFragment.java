package com.example.todo.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo.R;
import com.example.todo.adapter.TaskAdapter;
import com.example.todo.model.Task;
import com.example.todo.viewmodel.TaskViewModel;

public class TaskFragment extends Fragment implements TaskAdapter.TaskListener {
    private TaskViewModel viewModel;
    private TaskAdapter adapter;
    private int type;

    public static TaskFragment newInstance(int type) {
        TaskFragment fragment = new TaskFragment();
        Bundle args = new Bundle();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments() != null ? getArguments().getInt("type") : 0;
        viewModel = new ViewModelProvider(requireActivity()).get(TaskViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_task_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        RecyclerView recyclerView = view.findViewById(R.id.recycler_tasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        
        adapter = new TaskAdapter(this);
        recyclerView.setAdapter(adapter);

        // Add swipe to delete functionality
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                // Handle task deletion
                onTaskSwiped(adapter.getTasks().get(position));
            }
        }).attachToRecyclerView(recyclerView);

        // Observe tasks based on type
        switch (type) {
            case 0:
                viewModel.getAllTasks().observe(getViewLifecycleOwner(), adapter::setTasks);
                break;
            case 1:
                viewModel.getActiveTasks().observe(getViewLifecycleOwner(), adapter::setTasks);
                break;
            case 2:
                viewModel.getCompletedTasks().observe(getViewLifecycleOwner(), adapter::setTasks);
                break;
        }
    }

    @Override
    public void onTaskCheckedChanged(Task task, boolean isChecked) {
        task.setCompleted(isChecked);
        viewModel.updateTask(task);
    }

    @Override
    public void onTaskSwiped(Task task) {
        viewModel.deleteTask(task);
    }
} 
package com.example.todo.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todo.data.TaskDatabase;
import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskViewModel extends AndroidViewModel {
    private final TaskDatabase database;
    private final ExecutorService executorService;
    private final TaskRepository repository;
    private final LiveData<List<Task>> activeTasks;
    private final LiveData<List<Task>> completedTasks;

    public TaskViewModel(Application application) {
        super(application);
        database = TaskDatabase.getInstance(application);
        executorService = Executors.newSingleThreadExecutor();
        repository = new TaskRepository(application);
        activeTasks = repository.getActiveTasks();
        completedTasks = repository.getCompletedTasks();
    }

    public LiveData<List<Task>> getAllTasks() {
        return database.taskDao().getAllTasks();
    }

    public LiveData<List<Task>> getActiveTasks() {
        return activeTasks;
    }

    public LiveData<List<Task>> getCompletedTasks() {
        return completedTasks;
    }

    public void insertTask(Task task) {
        repository.insert(task);
    }

    public void updateTask(Task task) {
        repository.update(task);
    }

    public void deleteTask(Task task) {
        repository.delete(task);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        executorService.shutdown();
    }
} 
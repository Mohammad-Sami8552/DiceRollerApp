package com.example.todo.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.todo.data.TaskDao;
import com.example.todo.data.TaskDatabase;
import com.example.todo.model.Task;
import java.util.List;

public class TaskRepository {
    private final TaskDao taskDao;
    private final LiveData<List<Task>> activeTasks;
    private final LiveData<List<Task>> completedTasks;

    public TaskRepository(Application application) {
        TaskDatabase database = TaskDatabase.getInstance(application);
        taskDao = database.taskDao();
        activeTasks = taskDao.getActiveTasks();
        completedTasks = taskDao.getCompletedTasks();
    }

    public LiveData<List<Task>> getActiveTasks() {
        return activeTasks;
    }

    public LiveData<List<Task>> getCompletedTasks() {
        return completedTasks;
    }

    public void insert(Task task) {
        TaskDatabase.databaseWriteExecutor.execute(() -> {
            taskDao.insert(task);
        });
    }

    public void update(Task task) {
        TaskDatabase.databaseWriteExecutor.execute(() -> {
            taskDao.update(task);
        });
    }

    public void delete(Task task) {
        TaskDatabase.databaseWriteExecutor.execute(() -> {
            taskDao.delete(task);
        });
    }
} 
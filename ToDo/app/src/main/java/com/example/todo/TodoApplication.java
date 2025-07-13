package com.example.todo;

import android.app.Application;
import android.util.Log;
import com.example.todo.data.TaskDatabase;

public class TodoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            // Initialize database
            TaskDatabase.getInstance(this);
        } catch (Exception e) {
            Log.e("TodoApplication", "Error initializing database", e);
        }
    }
} 
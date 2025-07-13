package com.example.todo.data;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.example.todo.model.Task;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Task.class}, version = 1, exportSchema = false)
public abstract class TaskDatabase extends RoomDatabase {
    private static TaskDatabase instance;
    
    // Add executor for database operations
    public static final ExecutorService databaseWriteExecutor =
        Executors.newFixedThreadPool(4);

    public abstract TaskDao taskDao();

    public static synchronized TaskDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    TaskDatabase.class,
                    "task_database"
            )
            .fallbackToDestructiveMigration() // Allows database recreation if version changes
            .addCallback(roomCallback)
            .build();
        }
        return instance;
    }

    private static final RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            // Initialize database with sample data if needed
            databaseWriteExecutor.execute(() -> {
                TaskDao dao = instance.taskDao();
                // You can add sample tasks here if needed
            });
        }
    };
} 
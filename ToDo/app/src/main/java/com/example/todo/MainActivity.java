package com.example.todo;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.graphics.Typeface;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import android.content.res.Configuration;
import java.util.Locale;

import com.example.todo.adapter.TaskAdapter;
import com.example.todo.model.Task;
import com.example.todo.viewmodel.TaskViewModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.google.android.material.chip.ChipGroup;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements TaskAdapter.TaskListener {
    private TaskViewModel viewModel;
    private TaskAdapter activeTasksAdapter;
    private TaskAdapter completedTasksAdapter;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_main);

            // Initialize ViewModel
            viewModel = new ViewModelProvider(this).get(TaskViewModel.class);

            // Setup UI components
            setupToolbar();
            setupNavigationDrawer();
            setupRecyclerViews();
            setupFab();

            // Observe tasks with error handling
            observeTasks();
        } catch (Exception e) {
            Log.e("MainActivity", "Error in onCreate", e);
            showErrorDialog();
        }
    }

    private void setupToolbar() {
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupNavigationDrawer() {
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        
        // Add hamburger icon
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawerLayout, findViewById(R.id.toolbar),
            R.string.nav_drawer_open,
            R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Setup navigation drawer
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_theme) {
                toggleTheme();
            } else if (id == R.id.nav_language) {
                showLanguageDialog();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    private void setupRecyclerViews() {
        setupRecyclerView(R.id.active_tasks_list, true);
        setupRecyclerView(R.id.completed_tasks_list, false);
    }

    private void setupRecyclerView(int viewId, boolean isActiveList) {
        RecyclerView recyclerView = findViewById(viewId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        TaskAdapter adapter = new TaskAdapter(this);
        recyclerView.setAdapter(adapter);
        
        if (isActiveList) {
            activeTasksAdapter = adapter;
        } else {
            completedTasksAdapter = adapter;
        }

        // Add swipe to delete functionality
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, 
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            private final ColorDrawable background = new ColorDrawable(Color.parseColor("#FFE57373"));
            private final Drawable deleteIcon = ContextCompat.getDrawable(MainActivity.this, 
                    android.R.drawable.ic_menu_delete);

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, 
                                @NonNull RecyclerView.ViewHolder viewHolder, 
                                @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                Task task = adapter.getTasks().get(position);
                onTaskSwiped(task);
            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY,
                                  int actionState, boolean isCurrentlyActive) {
                
                View itemView = viewHolder.itemView;
                int iconMargin = (itemView.getHeight() - deleteIcon.getIntrinsicHeight()) / 2;

                if (dX > 0) { // Swiping to the right
                    background.setBounds(itemView.getLeft(), itemView.getTop(),
                            itemView.getLeft() + ((int) dX), itemView.getBottom());
                    deleteIcon.setBounds(itemView.getLeft() + iconMargin,
                            itemView.getTop() + iconMargin,
                            itemView.getLeft() + iconMargin + deleteIcon.getIntrinsicWidth(),
                            itemView.getBottom() - iconMargin);
                } else if (dX < 0) { // Swiping to the left
                    background.setBounds(itemView.getRight() + ((int) dX), itemView.getTop(),
                            itemView.getRight(), itemView.getBottom());
                    deleteIcon.setBounds(itemView.getRight() - iconMargin - deleteIcon.getIntrinsicWidth(),
                            itemView.getTop() + iconMargin,
                            itemView.getRight() - iconMargin,
                            itemView.getBottom() - iconMargin);
                } else {
                    background.setBounds(0, 0, 0, 0);
                    deleteIcon.setBounds(0, 0, 0, 0);
                }

                background.draw(c);
                deleteIcon.draw(c);

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        }).attachToRecyclerView(recyclerView);
    }

    private void setupFab() {
        FloatingActionButton fab = findViewById(R.id.fab_add_task);
        fab.setOnClickListener(v -> showAddTaskDialog());
    }

    private void observeTasks() {
        try {
            viewModel.getActiveTasks().observe(this, tasks -> {
                if (activeTasksAdapter != null) {
                    activeTasksAdapter.setTasks(tasks);
                }
            });

            viewModel.getCompletedTasks().observe(this, tasks -> {
                if (completedTasksAdapter != null) {
                    completedTasksAdapter.setTasks(tasks);
                }
            });
        } catch (Exception e) {
            Log.e("MainActivity", "Error observing tasks", e);
        }
    }

    private void showLanguageDialog() {
        String[] languages = getResources().getStringArray(R.array.languages);
        new MaterialAlertDialogBuilder(this)
            .setTitle(R.string.language)
            .setItems(languages, (dialog, which) -> {
                String lang = "";
                switch (which) {
                    case 0: lang = "en"; break;
                    case 1: lang = "hi"; break;
                    case 2: lang = "sa"; break;
                }
                setLocale(lang);
            })
            .show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        recreate();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_theme) {
            toggleTheme();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAddTaskDialog() {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_add_task, null);
        TextInputEditText taskInput = dialogView.findViewById(R.id.edit_task);
        ChipGroup priorityChipGroup = dialogView.findViewById(R.id.priority_chip_group);

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this)
                .setTitle(R.string.add_task)
                .setView(dialogView)
                .setPositiveButton(R.string.add, (dialog, which) -> {
                    String taskTitle = taskInput.getText().toString().trim();
                    if (!taskTitle.isEmpty()) {
                        Task task = new Task(taskTitle);
                        
                        // Set priority based on selected chip
                        int selectedChipId = priorityChipGroup.getCheckedChipId();
                        if (selectedChipId == R.id.chip_high) {
                            task.setPriority(2);
                        } else if (selectedChipId == R.id.chip_medium) {
                            task.setPriority(1);
                        }
                        
                        viewModel.insertTask(task);
                    }
                })
                .setNegativeButton(R.string.cancel, null);

        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(dialogInterface -> {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTypeface(Typeface.create("cursive", Typeface.BOLD));
            dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTypeface(Typeface.create("cursive", Typeface.BOLD));
            TextView titleView = dialog.findViewById(android.R.id.title);
            if (titleView != null) {
                titleView.setTypeface(Typeface.create("cursive", Typeface.BOLD));
            }
        });
        
        dialog.show();
    }

    private void toggleTheme() {
        int currentNightMode = AppCompatDelegate.getDefaultNightMode();
        if (currentNightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
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

    private void showErrorDialog() {
        new MaterialAlertDialogBuilder(this)
            .setTitle("Error")
            .setMessage("An unexpected error occurred. Please try again.")
            .setPositiveButton("Retry", (dialog, which) -> recreate())
            .setNegativeButton("Close", (dialog, which) -> finish())
            .show();
    }
}
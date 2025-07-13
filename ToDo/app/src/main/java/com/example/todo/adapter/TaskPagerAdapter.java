package com.example.todo.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.todo.ui.TaskFragment;

public class TaskPagerAdapter extends FragmentStateAdapter {

    public TaskPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return TaskFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return 3; // All, Active, Completed
    }
} 
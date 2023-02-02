package com.example.harjoitus678;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RunViewModel mRunViewModel;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private Button deleteButton;
    private Button sortByDateButton;
    private Button sortByDistanceButton;
    private Button sortByDurationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final RunListAdapter adapter = new RunListAdapter(new RunListAdapter.RunDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRunViewModel = new ViewModelProvider(this).get(RunViewModel.class);
        mRunViewModel.getAllRuns().observe(this, runs -> {
            adapter.submitList(runs);
        });

        deleteButton = findViewById(R.id.delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Run toDelete = adapter.getRun();
                if (toDelete != null) {
                    mRunViewModel.delete(toDelete);
                }
                else {
                    Toast.makeText(getApplicationContext(),
                            "Please select an item to delete",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        sortByDateButton = findViewById(R.id.sortByDate);
        sortByDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        sortByDistanceButton = findViewById(R.id.sortByDistance);
        sortByDistanceButton.setOnClickListener(view -> {

        });

        sortByDurationButton = findViewById(R.id.sortByDuration);
        sortByDurationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener( view -> {
            Intent intent = new Intent(MainActivity.this, NewRunActivity.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
        });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            String exercise = extras.getString("EXERCISE");
            String dst = extras.getString("DISTANCE");
            String drt = extras.getString("DURATION");
            double distance = Double.parseDouble(dst);
            int duration = Integer.parseInt(drt);
            Run run = new Run(exercise, distance, duration);
            mRunViewModel.insert(run);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}
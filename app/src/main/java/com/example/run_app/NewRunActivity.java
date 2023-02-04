package com.example.run_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class NewRunActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.runlistsql.REPLY";

    private Spinner exerciseSpinner;
    private EditText distance;
    private EditText duration;
    private Button addNewExercise;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_run);

        exerciseSpinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> exerciseAdapter = ArrayAdapter.createFromResource(this,
                R.array.exercise_array, android.R.layout.simple_spinner_dropdown_item);
        exerciseSpinner.setAdapter(exerciseAdapter);

        distance = findViewById(R.id.editDistance);
        duration = findViewById(R.id.editDuration);
        addNewExercise = findViewById(R.id.addNewButton);

        addNewExercise.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(distance.getText()) ||
                    TextUtils.isEmpty(duration.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            }
            else {
                String exercise = exerciseSpinner.getSelectedItem().toString();
                String dist = distance.getText().toString();
                String dura = duration.getText().toString();
                Bundle extras = new Bundle();
                extras.putString("EXERCISE", exercise);
                extras.putString("DISTANCE", dist);
                extras.putString("DURATION", dura);
                replyIntent.putExtras(extras);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}
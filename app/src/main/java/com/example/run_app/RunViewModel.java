package com.example.run_app;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RunViewModel extends AndroidViewModel {

    private RunRepository mRepository;
    private final LiveData<List<Run>> mAllRuns;
    private int choice;


    public RunViewModel(Application application) {
        super(application);
        mRepository = new RunRepository(application);
        mAllRuns = mRepository.getAllRuns(choice);
    }

    LiveData<List<Run>> getAllRuns() {
        return mRepository.getAllRuns(choice);
    }

    public void insert(Run run) {
        mRepository.insert(run);
    }

    public void delete(Run run) {
        mRepository.delete(run);
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

}

package com.example.harjoitus678;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class RunViewModel extends AndroidViewModel {

    private RunRepository mRepository;
    private final LiveData<List<Run>> mAllRuns;


    public RunViewModel(Application application) {
        super(application);
        mRepository = new RunRepository(application);
        mAllRuns = mRepository.getAllRuns();
    }

    LiveData<List<Run>> getAllRuns() {
            return mRepository.getAllRuns();
    }

    public void insert(Run run) {
        mRepository.insert(run);
    }

    public void delete(Run run) {
        mRepository.delete(run);
    }

}

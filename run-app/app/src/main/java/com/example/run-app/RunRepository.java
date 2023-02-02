package com.example.harjoitus678;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class RunRepository {

    private RunDao mRunDao;
    private LiveData<List<Run>> mAllRuns;

    RunRepository(Application application) {
        RunRoomDatabase db = RunRoomDatabase.getDatabase(application);
        mRunDao = db.runDao();
        mAllRuns = mRunDao.getRunsByDate();
    }

    LiveData<List<Run>> getAllRuns() {
        return mRunDao.getRunsByDate();
    }


    void insert(Run run) {
        RunRoomDatabase.databaseWriteExecutor.execute(() ->
                mRunDao.insert(run));
    }

    public void delete(Run run) {
        RunRoomDatabase.databaseWriteExecutor.execute(() -> {
            mRunDao.deleteRun(run);
        });
    }

}

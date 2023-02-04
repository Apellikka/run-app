package com.example.run_app;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RunRepository {

    private RunDao mRunDao;
    private LiveData<List<Run>> mAllRuns;

    RunRepository(Application application) {
        RunRoomDatabase db = RunRoomDatabase.getDatabase(application);
        mRunDao = db.runDao();
    }

    LiveData<List<Run>> getAllRuns(int choice) {
        mAllRuns = mRunDao.getRuns(choice);
        return mAllRuns;
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

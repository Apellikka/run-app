package com.example.harjoitus678;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RunDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Run run);

    @Query("DELETE FROM run_table")
    void deleteAll();

    @Query("SELECT * FROM run_table ORDER BY date")
    LiveData<List<Run>> getRunsByDate();

    @Query("SELECT * FROM run_table ORDER BY distance ASC")
    LiveData<List<Run>> getRunsByDistance();

    @Query("SELECT * FROM run_table ORDER BY duration ASC")
    LiveData<List<Run>> getRunsByDuration();
    @Delete
    void deleteRun(Run run);
}

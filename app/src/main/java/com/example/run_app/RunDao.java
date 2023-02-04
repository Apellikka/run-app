package com.example.run_app;

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

    @Query("SELECT * FROM run_table ORDER BY " +
            "CASE WHEN:choice=1 THEN date END ASC," +
            "CASE WHEN:choice=2 THEN distance END ASC," +
            "CASE WHEN:choice=3 THEN duration END ASC")
    LiveData<List<Run>> getRuns(int choice);

    @Query("SELECT * FROM run_table ORDER BY distance ASC")
    LiveData<List<Run>> getRunsByDistance();

    @Query("SELECT * FROM run_table ORDER BY duration ASC")
    LiveData<List<Run>> getRunsByDuration();
    @Delete
    void deleteRun(Run run);
}

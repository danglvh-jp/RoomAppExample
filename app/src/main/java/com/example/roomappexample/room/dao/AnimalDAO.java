package com.example.roomappexample.room.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomappexample.room.entity.Animal;

import java.util.List;

@Dao
public interface AnimalDAO {
    @Insert
    void insert(Animal... animals);

    @Delete
    void delete(Animal... animals);

    @Query("DELETE FROM Animal")
    void deleteAll();

    @Query("SELECT * FROM Animal")
    LiveData<List<Animal>> getAll();

    @Query("SELECT * FROM Animal where id=:id1")
    Animal getById(String id1);
}

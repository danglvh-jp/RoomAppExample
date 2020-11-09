package com.example.roomappexample.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roomappexample.room.AppDatabase;
import com.example.roomappexample.room.dao.AnimalDAO;
import com.example.roomappexample.room.entity.Animal;

import java.util.List;

public class AnimalRepository {
    private AnimalDAO mDao;
    public AnimalRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        mDao = db.animalDAO();
    }

    public LiveData<List<Animal>>getAll(){
        return mDao.getAll();
    }

    public void insert(Animal...animals){
        new Thread(()->{
            mDao.insert(animals);
        }).start();
    }
}

package com.example.roomappexample.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomappexample.repository.AnimalRepository;
import com.example.roomappexample.room.entity.Animal;

import java.util.List;

public class AnimalViewModel extends AndroidViewModel {
    AnimalRepository mRepository;
    public AnimalViewModel(@NonNull Application application) {
        super(application);
        mRepository = new AnimalRepository(application);
    }

    public LiveData<List<Animal>> getAll(){
        return mRepository.getAll();
    }

    public void insert(Animal animal){
        mRepository.insert(animal);
    }
}

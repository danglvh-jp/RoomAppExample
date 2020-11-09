package com.example.roomappexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.roomappexample.repository.AnimalRepository;
import com.example.roomappexample.room.AppDatabase;
import com.example.roomappexample.room.entity.Animal;
import com.example.roomappexample.viewmodel.AnimalViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animal tiger1 = new Animal("t1", "Vinh 1", 9);
        Animal elphant1 = new Animal("p1", "Vinh 2", 12);
        Animal mouse1 = new Animal("m1", "Vinh 3", 5);

//        AppDatabase db = AppDatabase.getDatabase(this);
//        AnimalRepository animalRepository = new AnimalRepository(getApplication());
//        animalRepository.insert(mouse1);
        AnimalViewModel manimalViewModel = new AnimalViewModel(getApplication());
        manimalViewModel.getAll().observe(this, animals->{
            String dsConvat ="";
            for (Animal animal : animals){
                dsConvat = dsConvat + animal.getName() +",";
            }
            Toast.makeText(this, dsConvat, Toast.LENGTH_SHORT).show();
        });
//        db.animalDAO().insert(elphant1);
////        db.animalDAO().insert(tiger1);
//
////        List<Animal> list = db.animalDAO().getAll();
//        Animal convoi = db.animalDAO().getById("p1");
////        Toast.makeText(this, list.get(0).getName(), Toast.LENGTH_LONG).show();
////        Toast.makeText(this, ""+convoi.getAge(), Toast.LENGTH_LONG).show();
    }
}
package com.example.recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView personRv;
    PersonRvAdapter personRvAdapter;
    List<PersonModel> personList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personRv = findViewById(R.id.person_rv);
        setUpRecyclerView();
    }

    private void setUpRecyclerView(){
        // create dummy data model
        PersonModel model = new PersonModel("Reham","20");
        // add it to list
        for(int i = 0; i<20; i++){
            model.setAge(model.getAge()+i);
            personList.add(model);
        }


        // pass the list to the adapter
        personRvAdapter = new PersonRvAdapter(personList);
        // define recyclerview configurations
        personRv.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        personRv.addItemDecoration(new DividerItemDecoration(MainActivity.this,LinearLayoutManager.VERTICAL));
        // add recyclerview to adapter
        personRv.setAdapter(personRvAdapter);
    }
}
package com.example.recyclerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private RecyclerView recyclerView;
    List<String> names =new ArrayList<>();

    private  int[] images={R.drawable.tomato, R.drawable.carrots, R.drawable.onion, R.drawable.blur, R.drawable.potatoes, R.drawable.chili_peper};
    private  RecyclerView.LayoutManager layoutManager;

    private RecyclerAdapter adapter;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        recyclerView=findViewById(R.id.recyclerView);
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        names.add("Tomato");
        names.add("Carrot");
        names.add("Onion");
        names.add("Garlic");
        names.add("Potato");
        names.add("Chilly");
        adapter= new RecyclerAdapter(images,names, this);

        recyclerView.setAdapter(adapter);
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem menuItem= menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView)menuItem.getActionView();
        searchView.setOnQueryTextListener( this);

        return true;


    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String userInput= newText.toLowerCase();
        List<String> names =new ArrayList<>();

        for(String name: names){
            if(name.toLowerCase().contains(userInput)){
                names.add(name);
            }
        }
        adapter.upadateList(names);
        return false;
    }
}

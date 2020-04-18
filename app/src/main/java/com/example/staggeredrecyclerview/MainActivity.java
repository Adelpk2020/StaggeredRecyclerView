package com.example.staggeredrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int NUM_COLUMNS = 2;

    private ArrayList<String> imageUrls = new ArrayList<>();
    private ArrayList<String> imageNames = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        imageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        imageNames.add("Portugal");

        imageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        imageNames.add("Rocky Mountain National Park");


        imageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        imageNames.add("Mahahual");

        imageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        imageNames.add("Frozen Lake");


        imageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        imageNames.add("White Sands Desert");

        imageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        imageNames.add("Austrailia");

        imageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        imageNames.add("Washington");

        initRecyclerView();

    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: initializing staggered recyclerview.");
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        StaggeredRecyclerViewAdapter adapter=new StaggeredRecyclerViewAdapter(this,imageNames,imageUrls);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}

package com.example.recycler_sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recycler_sample.adapter.ParentAdapter;
import com.example.recycler_sample.model.ChildModel;
import com.example.recycler_sample.model.GeneralViewModel;
import com.example.recycler_sample.model.ShortsModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView parent_rv;
    private ParentAdapter recyclerViewAdapter;
    private List<ShortsModel> shortsList;
    private List<ChildModel>shorts;
    private List<GeneralViewModel>generalList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        shortsList=new ArrayList<>();
        generalList=new ArrayList<>();
        shorts=new ArrayList<>();

        // For generating the shorts sample data
        generateShortsData();

        // For generating the general view data
        generateGeneralViewsData();

        setContentView(R.layout.activity_main);
        parent_rv=findViewById(R.id.rec_view);
        parent_rv.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewAdapter=new ParentAdapter(shortsList,generalList,this);
        parent_rv.setAdapter(recyclerViewAdapter);
    }
    void generateShortsData(){
        shorts.add(new ChildModel(R.drawable.image));
        shorts.add(new ChildModel(R.drawable.fourth));
        shorts.add(new ChildModel(R.drawable.second));
        shorts.add(new ChildModel(R.drawable.first));
        shorts.add(new ChildModel(R.drawable.images));
        shorts.add(new ChildModel(R.drawable.fifth));
        shorts.add(new ChildModel(R.drawable.third));
        shorts.add(new ChildModel(R.drawable.first));
        shortsList.add(new ShortsModel("Shorts",shorts));
    }
    void generateGeneralViewsData(){
        generalList.add(new GeneralViewModel(R.drawable.first,"This is the first video"));
        generalList.add(new GeneralViewModel(R.drawable.second,"This is the second video"));
        generalList.add(new GeneralViewModel(R.drawable.third,"This is the third video"));
        generalList.add(new GeneralViewModel(R.drawable.fourth,"This is the fourth video"));
        generalList.add(new GeneralViewModel(R.drawable.fifth,"This is the fifth video"));
        generalList.add(new GeneralViewModel(R.drawable.image,"This is the sixth video"));
        generalList.add(new GeneralViewModel(R.drawable.images,"This is the seventh video"));
        generalList.add(new GeneralViewModel(R.drawable.fifth,"This is the eighth video"));
        generalList.add(new GeneralViewModel(R.drawable.second,"This is the ninth video"));
        generalList.add(new GeneralViewModel(R.drawable.fourth,"This is the tenth video"));
    }
}
package com.example.lecture3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Subject> arrayList;
    private  SubjectAdapter subjectAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager); ///방금 만든 layoutmanager을 recyclerview로 넣어줘라


        arrayList = new ArrayList<>();
        /// 아까 만든 MainAdapter을 가져와서 arrayList에 값을 넣어 준 것이다

        Subject subject = new Subject("잘생겨지는법", "강민우","폐강");
        Subject subject2 = new Subject("무야호", "무도","알래스카");

        arrayList.add(subject);
        arrayList.add(subject2);



        subjectAdapter = new SubjectAdapter((arrayList));
        subjectAdapter.notifyDataSetChanged();


        recyclerView.setAdapter(subjectAdapter); ///담아져있는 데이터를 recyclerView에 담아줘라





    }
}

package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MainData> arrayList;
    private  MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager); ///방금 만든 layoutmanager을 recyclerview로 넣어줘라


        arrayList = new ArrayList<>();
        /// 아까 만든 MainAdapter을 가져와서 arrayList에 값을 넣어 준 것이다
        mainAdapter = new MainAdapter((arrayList));
        recyclerView.setAdapter(mainAdapter); ///담아져있는 데이터를 recyclerView에 담아줘라



        ///추가버튼의 액션을 구현한다
        Button btn_add = (Button)findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///MainData를 가져온다
                MainData mainData = new MainData(R.mipmap.ic_launcher, "강민우","리사이클러뷰");
                arrayList.add(mainData);
                mainAdapter.notifyDataSetChanged(); ///새로고침




            }
        });


    }
}
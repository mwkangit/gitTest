package com.example.lecture3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    Button btn; // 버튼을 추가하는 버튼
    LinearLayout View; // 추가하는 버튼을 놓을 Layout
    int count = 0; // 버튼의 개수를 제한하는 변수
                Drawable drawable;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            DisplayMetrics dm = getResources().getDisplayMetrics(); // dp 형식의 변수를 만든다
            int size = Math.round(20 * dm.density); // dp 의 값을 정의한다

            btn = (Button) findViewById(R.id.btn);

            Button button[] = new Button[10]; // 버튼의 개수를 정의한다
            for(int i = 0 ; i < 10 ; i++){
                button[i] = new Button(this);
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams( // xml 에 추가 될 View의 속성을 정의하는 객체를 만든다
                    LinearLayout.LayoutParams.WRAP_CONTENT, // View 의 width 를 정의한다
                LinearLayout.LayoutParams.WRAP_CONTENT  // View 의 height 를 정의한다
        );

        params.topMargin = size;  // 버튼 사이의 Margin 을 정의한다
        params.gravity = Gravity.CENTER; // 버튼을 CENTER 로 정렬

        View = (LinearLayout) findViewById(R.id.lay); // 추가할 버튼을 배치할 Layout 의 아이디를 가져온다



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                if(count < 10) { // 버튼은 10개까지만 생성 가능하다
                    button[count].setText("abc"); // 버튼의 text 를 정의한다
                    button[count].setTextColor(Color.parseColor("#000000")); // text 의 색깔을 정의해준다
                    button[count].setBackgroundResource(R.drawable.button_round); // drawable xml 파일을 불러와서 button 에 둥근 속성을 준다
                    View.addView(button[count]); // Layout 에 버튼을 추가한다
                    button[count].setLayoutParams(params); // 버튼에 위에 설정한 View 속성을 추가한다
                    count++;
                } else{
                    Toast.makeText(getApplicationContext(), "수업은 10개까지만 생성 가능합니다", Toast.LENGTH_SHORT).show(); // 버튼을 11개 이상 만들려고 할 때 Toast 해준다
                }
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        SubjectAdapter adapter = new SubjectAdapter();


        adapter.addItem(new Subject("ICT개론", "윤경로", "1 : 30"));
        adapter.addItem(new Subject("자료구조및알고리즘", "임상범", "2 : 30"));
        adapter.addItem(new Subject("시스템프로그래밍", "임민규", "3 : 30"));

        recyclerView.setAdapter(adapter);


    }
}


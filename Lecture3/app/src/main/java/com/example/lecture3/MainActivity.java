package com.example.lecture3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Subject> arrayList;
    private  SubjectAdapter subjectAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private ArrayList<AddSubject> arrayList2;
    private  AddSubjectAdapter addsubjectAdapter;
    private RecyclerView recyclerView2;
    private LinearLayoutManager linearLayoutManager2;

    Button add_button; // 버튼을 추가하는 버튼
    LinearLayout View; // 추가하는 버튼을 놓을 Layout
    int count = 0; // 버튼의 개수를 제한하는 변수
    Drawable drawable;


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




        add_button = (Button) findViewById(R.id.add_button);
        recyclerView2 = (RecyclerView)findViewById(R.id.recyclerView2);
        linearLayoutManager2 = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(linearLayoutManager2); ///방금 만든 layoutmanager을 recyclerview로 넣어줘라

        arrayList2 = new ArrayList<>();

        addsubjectAdapter = new AddSubjectAdapter(arrayList2, this);
        recyclerView2.setAdapter(addsubjectAdapter); ///담아져있는 데이터를 recyclerView에 담아줘라

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                String add_subject = subjectAdapter.new_button_name; // slidingpanel에서 클릭한 과목명을 가져온다
                String add_professor = subjectAdapter.new_button_professor; // slidingpanel에서 클릭한 교수명을 가져온다
                int distinguisher = 0; // 이미 생성한 과목을 더 생성하려는 것인지 판별하는 변수이다 (1이면 이미 같은 과목명의 과목이 생성되어 있는 것이다)
                for(int i = 0 ; i < arrayList2.size() ; i++){ // 같은 이름의 과목이 있는지 검색
                    if(arrayList2.get(i).subject == add_subject){
                        distinguisher = 1;
                        break;
                    }
                }
                if(distinguisher == 0) { // 과목을 추가한다
                    AddSubject addSubject = new AddSubject(add_subject, add_professor);
                    arrayList2.add(addSubject);

                    addsubjectAdapter.notifyDataSetChanged();
                }else{ // 이미 과목이 있으면 Toast 띄운다
                    Toast.makeText(getApplicationContext(),add_subject + "는 이미 선택하셨어요!", Toast.LENGTH_SHORT).show();
                }


            }
        });








        /*DisplayMetrics dm = getResources().getDisplayMetrics(); // dp 형식의 변수를 만든다
        int size = Math.round(20 * dm.density); // dp 의 값을 정의한다

        add_button = (Button) findViewById(R.id.add_button);

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



        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                if(count < 10 && (subjectAdapter.new_button_name != null)) { // 버튼은 10개까지만 생성 가능하다
                    button[count].setText(subjectAdapter.new_button_name); // 버튼의 text 를 정의한다
                    button[count].setTextColor(Color.parseColor("#000000")); // text 의 색깔을 정의해준다
                    button[count].setBackgroundResource(R.drawable.button_round); // drawable xml 파일을 불러와서 button 에 둥근 속성을 준다
                    View.addView(button[count]); // Layout 에 버튼을 추가한다
                    button[count].setLayoutParams(params); // 버튼에 위에 설정한 View 속성을 추가한다
                    count++;
                } else{
                    Toast.makeText(getApplicationContext(), "수업은 10개까지만 생성 가능합니다", Toast.LENGTH_SHORT).show(); // 버튼을 11개 이상 만들려고 할 때 Toast 해준다
                }
            }
        });*/













    }
}

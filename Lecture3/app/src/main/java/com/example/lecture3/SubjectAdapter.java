package com.example.lecture3;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.CustomViewHolder> {

    private ArrayList<Subject> arrayList; // MainActivity에서 오는 항목을 저장하는 Arraylist
    public ArrayList<AddSubject> Add_Arraylist = new ArrayList<>(); // 클릭되는 항목 저장하는 Arraylist

    int counter_click = 0;
    String new_button_name = null;
    String new_button_professor = null;


    public SubjectAdapter(ArrayList<Subject> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    /// listview 메뉴가 처음 생성될 때 생명주기를 뜻한다
    public SubjectAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    ///실제 추가 될 때에 대한 생명주기
    public void onBindViewHolder(@NonNull SubjectAdapter.CustomViewHolder holder, int position) {
        ///imageview를 생성한 애들을 가져온다

        holder.subject_name.setText(arrayList.get(position).getSubject());
        holder.professor_name.setText(arrayList.get(position).getProfessor());
        holder.time_time.setText(arrayList.get(position).getTime());
        ///listview가 클릭이 됬을 때와 long click이 됬을 때를 나타내 줄 수 있다
        holder.itemView.setId(position); /// position값을 가져온다
        LinearLayout subject_item_layout = (LinearLayout) holder.itemView.findViewById(R.id.subject_item_layout); // 각 항목에 대한 레이아웃의 아이디를 가져온다

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // String curName = holder.subject_name.getText().toString(); ///리사이클러 아이템 중 클릭한 친구의 이름을 가져온다
                // Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show(); /// curName을 짧은 시간동안 띄울 것이다
                //holder.add_btn.setId(Integer.parseInt("10")); // 각 항목마다 아이디 부여하기 가능하다
                boolean distinguisher = false; // 이미 파란색이면 true로 바꿔주고 흰색이면 false를 유지한다
                new_button_name = holder.subject_name.getText().toString(); // 과목을 누르면 new_button_name 전역변수에 과목명이 등록된다
                new_button_professor = holder.professor_name.getText().toString(); // 과목을 누르면 new_button_professor 전역변수에 교수님명이 등록된다
                for(int i = 0 ; i < Add_Arraylist.size() ; i++){ // 이미 파란불이 들어온 항목을 또 눌렀는지 확인한다
                    if(Add_Arraylist.get(i).subject == new_button_name){
                        Add_Arraylist.remove(i);
                        subject_item_layout.setBackgroundColor(Color.parseColor("#FFFFFFFF")); // 항목을 흰색으로 바꾼다
                        distinguisher = true;
                        break;
                    }
                }
                if(distinguisher == false) { // 클릭된 항목이 들어가는 Arraylist에 넣어주고 항목은 파란색으로 바꾼다
                    AddSubject addSubject = new AddSubject(new_button_name, new_button_professor);
                    Add_Arraylist.add(addSubject);
                    subject_item_layout.setBackgroundColor(Color.parseColor("#0027FF"));
                }

                /*counter_click = (counter_click + 1) % 2;
                if(counter_click == 0){
                    holder.add_btn.setVisibility(View.INVISIBLE);
                }
                else{
                    holder.add_btn.setVisibility(View.VISIBLE);
                }

                int view = holder.itemView.getId();
                */

            }
        });

        /*holder.add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new_button_name = holder.subject_name.getText().toString(); // 과목을 누르면 new_button_name 전역변수에 과목명이 등록된다
                new_button_professor = holder.professor_name.getText().toString(); // 과목을 누르면 new_button_professor 전역변수에 교수님명이 등록된다


            }
        });*/





    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }



    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView subject_name;
        protected TextView professor_name;
        protected TextView time_time;
        //protected Button add_btn;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.subject_name =(TextView) itemView.findViewById(R.id.subject_name); ///activity형 클래스 파일이 아니기 때문에 itemview를 가져온다
            this.professor_name = (TextView) itemView.findViewById(R.id.professor_name);
            this.time_time = (TextView) itemView.findViewById(R.id.time_time);
            //this.add_btn = (Button) itemView.findViewById(R.id.add_btn);
            subject_name.setTextColor(Color.parseColor("#000000"));
            professor_name.setTextColor(Color.parseColor("#000000"));
            time_time.setTextColor(Color.parseColor("#000000"));
            //add_btn.setTextColor(Color.parseColor("#000000"));



        }
    }
}

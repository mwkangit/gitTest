package com.example.lecture3;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.CustomViewHolder> {

    private ArrayList<Subject> arrayList;
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
        holder.itemView.setTag(position); /// position값을 가져온다


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = holder.subject_name.getText().toString(); ///리사이클러 아이템 중 클릭한 친구의 이름을 가져온다
                Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show(); /// curName을 짧은 시간동안 띄울 것이다
                new_button_name = holder.subject_name.getText().toString();
                new_button_professor = holder.professor_name.getText().toString();
                counter_click = (counter_click + 1) % 2;
                if(counter_click == 0){
                    holder.add_btn.setVisibility(View.INVISIBLE);
                }
                else{
                    holder.add_btn.setVisibility(View.VISIBLE);
                }



            }
        });

        holder.add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new_button_name = holder.subject_name.getText().toString();
            }
        });




    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }



    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView subject_name;
        protected TextView professor_name;
        protected TextView time_time;
        protected Button add_btn;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.subject_name =(TextView) itemView.findViewById(R.id.subject_name); ///activity형 클래스 파일이 아니기 때문에 itemview를 가져온다
            this.professor_name = (TextView) itemView.findViewById(R.id.professor_name);
            this.time_time = (TextView) itemView.findViewById(R.id.time_time);
            this.add_btn = (Button) itemView.findViewById(R.id.add_btn);
            subject_name.setTextColor(Color.parseColor("#000000"));
            professor_name.setTextColor(Color.parseColor("#000000"));
            time_time.setTextColor(Color.parseColor("#000000"));
            add_btn.setTextColor(Color.parseColor("#000000"));



        }
    }
}

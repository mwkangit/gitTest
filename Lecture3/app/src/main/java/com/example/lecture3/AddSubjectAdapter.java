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

public class AddSubjectAdapter extends RecyclerView.Adapter<AddSubjectAdapter.CustomViewHolder> {

    private ArrayList<AddSubject> arrayList;

    public AddSubjectAdapter(ArrayList<AddSubject> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    /// listview 메뉴가 처음 생성될 때 생명주기를 뜻한다
    public AddSubjectAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.addsubject_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    ///실제 추가 될 때에 대한 생명주기
    public void onBindViewHolder(@NonNull AddSubjectAdapter.CustomViewHolder holder, int position) {
        ///imageview를 생성한 애들을 가져온다

        holder.subject_name.setText(arrayList.get(position).getSubject());
        holder.professor_name.setText(arrayList.get(position).getProfessor());
        ///listview가 클릭이 됬을 때와 long click이 됬을 때를 나타내 줄 수 있다
        holder.itemView.setTag(position); /// position값을 가져온다


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = holder.subject_name.getText().toString(); ///리사이클러 아이템 중 클릭한 친구의 이름을 가져온다
                Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show(); /// curName을 짧은 시간동안 띄울 것이다;




            }
        });





        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            /// 바깥에서 추가버튼을 누르면 listview가 추가 되는 것은 MainActivity 쪽에다가 구현을 할 것이다
            /// Adapter에서는 longclick을 눌렀을 때 listview를 삭제하는 것을 만들어 볼 것이다

            public boolean onLongClick(View v) {
                remove(holder.getAdapterPosition());

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public void remove(int position){
        try{
            arrayList.remove(position);
            notifyItemRemoved(position); /// notify는 새로고침이라는 뜻으로 listview를 지우고 새로고침 해주는 것이다
        } catch(IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView subject_name;
        protected TextView professor_name;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.subject_name =(TextView) itemView.findViewById(R.id.subject_name); ///activity형 클래스 파일이 아니기 때문에 itemview를 가져온다
            this.professor_name = (TextView) itemView.findViewById(R.id.professor_name);

            subject_name.setTextColor(Color.parseColor("#000000"));
            professor_name.setTextColor(Color.parseColor("#000000"));





        }
    }
}

package com.example.recyclerviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    private ArrayList<MainData> arrayList;

    public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    /// listview 메뉴가 처음 생성될 때 생명주기를 뜻한다
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    ///실제 추가 될 때에 대한 생명주기
    public void onBindViewHolder(@NonNull MainAdapter.CustomViewHolder holder, int position) {
        ///imageview를 생성한 애들을 가져온다
        holder.iv_profile.setImageResource(arrayList.get(position).getIv_profile());
        holder.tv_name.setText(arrayList.get(position).getTv_name());
        holder.tv_content.setText(arrayList.get(position).getTv_content());
        ///listview가 클릭이 됬을 때와 long click이 됬을 때를 나타내 줄 수 있다
        holder.itemView.setTag(position); /// position값을 가져온다
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = holder.tv_name.getText().toString(); ///리사이클러 아이템 중 클릭한 친구의 이름을 가져온다
                Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show(); /// curName을 짧은 시간동안 띄울 것이다

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

        protected ImageView iv_profile;
        protected TextView tv_name;
        protected TextView tv_content;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile =(ImageView) itemView.findViewById(R.id.iv_profile); ///activity형 클래스 파일이 아니기 때문에 itemview를 가져온다
            this.tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            this.tv_content = (TextView) itemView.findViewById(R.id.tv_content);

        }
    }
}

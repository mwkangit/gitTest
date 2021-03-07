package com.example.lecture3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder> {
    ArrayList<Subject> items = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.subject_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Subject item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Subject item){
        items.add(item);
    }

    public void setItems(ArrayList<Subject> items){
        this.items = items;
    }

    public Subject getItem(int position){
        return items.get(position);
    }

    public Subject setItem(int position, Subject item){
        return items.set(position, item);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView subject_name;
        TextView professor_name;
        TextView time_time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            subject_name = itemView.findViewById(R.id.subject_name);
            professor_name = itemView.findViewById(R.id.professor_name);
            time_time = itemView.findViewById(R.id.time_time);

        }

        public void setItem(Subject item){
            subject_name.setText(item.getSubject());
            professor_name.setText(item.getProfessor());
            time_time.setText(item.getTime());

        }



    }
}

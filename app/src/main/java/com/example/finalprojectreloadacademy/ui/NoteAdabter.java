package com.example.finalprojectreloadacademy.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectreloadacademy.R;
import com.example.finalprojectreloadacademy.model.Note;

import java.util.ArrayList;

public class NoteAdabter extends RecyclerView.Adapter<NoteAdabter.NoteViewHolder> {
ArrayList<Note>arrayList;

    public NoteAdabter(ArrayList<Note> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note,null,false);
        NoteViewHolder noteViewHolder=new NoteViewHolder(view);
        return noteViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note=arrayList.get(position);
        holder.message.setText(note.getMessage());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {
      TextView message;
        public NoteViewHolder(@NonNull  View itemView) {
            super(itemView);
            message=itemView.findViewById(R.id.mesage_item_id);
        }
    }
}

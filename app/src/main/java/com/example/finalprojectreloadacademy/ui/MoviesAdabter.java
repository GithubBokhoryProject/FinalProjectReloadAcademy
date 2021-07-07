package com.example.finalprojectreloadacademy.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.finalprojectreloadacademy.databinding.ItemMoviesBinding;
import com.example.finalprojectreloadacademy.model.MoviesModel;


import java.util.ArrayList;

public class MoviesAdabter extends RecyclerView.Adapter<MoviesAdabter.MoviesViewHolder> {
    ArrayList<MoviesModel>arrayList;

    public MoviesAdabter(ArrayList<MoviesModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMoviesBinding binding=ItemMoviesBinding.inflate(LayoutInflater.from(parent.getContext()));
        MoviesViewHolder moviesViewHolder=new MoviesViewHolder(binding);
        return moviesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        MoviesModel moviesModel=arrayList.get(position);
        holder.bindingholder.nameItem.setText(moviesModel.getName());
        Glide.with(holder.bindingholder.getRoot().getContext()).load(moviesModel.getImageurl()).into(holder.bindingholder.imgItem);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MoviesViewHolder extends RecyclerView.ViewHolder {
        ItemMoviesBinding bindingholder;
        public MoviesViewHolder(@NonNull  ItemMoviesBinding itemView) {
            super(itemView.getRoot());
            bindingholder=itemView;
        }
    }
}

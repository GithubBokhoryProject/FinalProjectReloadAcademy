package com.example.finalprojectreloadacademy.ui.chat;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectreloadacademy.model.Note;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChatViewModel extends ViewModel {
    FirebaseDatabase database = FirebaseDatabase.getInstance();;
    DatabaseReference myRef= database.getReference("Notes");
    MutableLiveData<DataSnapshot> snapshotMutableLiveData= new MutableLiveData<>();
    public MutableLiveData<DataSnapshot> getData() {
        //Read From DataBase
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                snapshotMutableLiveData.setValue(snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return snapshotMutableLiveData;

    }
}

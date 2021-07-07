package com.example.finalprojectreloadacademy.ui.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectreloadacademy.databinding.FragmentChatBinding;
import com.example.finalprojectreloadacademy.model.Note;
import com.example.finalprojectreloadacademy.ui.NoteAdabter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class FragmentChat extends Fragment {
    private FragmentChatBinding binding;
    ChatViewModel chatViewModel;
    ArrayList<Note> arrayList;
    FirebaseDatabase database;
    DatabaseReference myRef;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentChat() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentChat newInstance(String param1, String param2) {
        FragmentChat fragment = new FragmentChat();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        binding=FragmentChatBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        // Inflate the layout for this fragment
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Notes");
        arrayList=new ArrayList<>();
        chatViewModel= ViewModelProviders.of(this).get(ChatViewModel.class);
        chatViewModel.getData().observe(getViewLifecycleOwner(), new Observer<DataSnapshot>() {
            @Override
            public void onChanged(DataSnapshot dataSnapshot) {
                arrayList.clear();
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    String id=ds.child("id").getValue().toString();
                    String message=ds.child("message").getValue().toString();
                    arrayList.add(new Note(id,message));
                }
                NoteAdabter adabter=new NoteAdabter(arrayList);
                RecyclerView.LayoutManager manager=new LinearLayoutManager(getContext());
                binding.rvId.setLayoutManager(manager);
                binding.rvId.setAdapter(adabter);

            }
        });

        //////////////////////////////
        binding.btnSaveId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id=myRef.push().getKey();
                Map<String,String> map=new HashMap<>();
                map.put("id",myRef.push().getKey());
                map.put("message",binding.editId.getText().toString());
                myRef.child(id).setValue(map);
                binding.editId.setText("");
            }
        });
        ///////////////////////////////
        return root;
    }
/*
    @Override
    public void onStart() {
        super.onStart();
        //Read From DataBase
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for(DataSnapshot ds:snapshot.getChildren()){
                    String id=ds.child("id").getValue().toString();
                    String message=ds.child("message").getValue().toString();
                    arrayList.add(new Note(id,message));
                }
                NoteAdabter adabter=new NoteAdabter(arrayList);
                RecyclerView.LayoutManager manager=new LinearLayoutManager(getContext());
                binding.rvId.setLayoutManager(manager);
                binding.rvId.setAdapter(adabter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }*/
}
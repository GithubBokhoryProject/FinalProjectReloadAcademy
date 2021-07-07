package com.example.finalprojectreloadacademy.ui.message;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.finalprojectreloadacademy.databinding.FragmentMessageBinding;

public class FragmentMessage extends Fragment {
private FragmentMessageBinding binding;
MessageViewModel messageViewModel;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentMessage() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static FragmentMessage newInstance(String param1, String param2) {
        FragmentMessage fragment = new FragmentMessage();
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
        binding= FragmentMessageBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        messageViewModel= ViewModelProviders.of(this).get(MessageViewModel.class);
        messageViewModel.stringMutableLiveData.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.txtMessageId.setText(s);
            }
        });
        messageViewModel.getData();
        // Inflate the layout for this fragment

        return root;
    }
}
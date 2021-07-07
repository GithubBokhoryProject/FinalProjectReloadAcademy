package com.example.finalprojectreloadacademy.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectreloadacademy.databinding.FragmentProfileBinding;
import com.example.finalprojectreloadacademy.model.MoviesModel;
import com.example.finalprojectreloadacademy.ui.MoviesAdabter;

import java.util.ArrayList;


public class FragmentProfile extends Fragment {
private FragmentProfileBinding binding;
ProfileViewModel profileViewModel;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentProfile() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentProfile newInstance(String param1, String param2) {
        FragmentProfile fragment = new FragmentProfile();
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
        binding=FragmentProfileBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        // Inflate the layout for this fragment
        profileViewModel= ViewModelProviders.of(this).get(ProfileViewModel.class);
        profileViewModel.getData().observe(getViewLifecycleOwner(), new Observer<ArrayList<MoviesModel>>() {
            @Override
            public void onChanged(ArrayList<MoviesModel> moviesModels) {
                MoviesAdabter adabter=new MoviesAdabter(moviesModels);
                binding.rvId.setAdapter(adabter);
                binding.rvId.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false));
            }
        });
        return root;
    }
}
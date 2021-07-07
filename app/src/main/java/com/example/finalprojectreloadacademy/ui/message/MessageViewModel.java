package com.example.finalprojectreloadacademy.ui.message;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MessageViewModel extends ViewModel {
    MutableLiveData<String> stringMutableLiveData=new MutableLiveData<>();

    public void getData(){
        stringMutableLiveData.setValue("Message Fragment");
    }
}

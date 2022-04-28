package com.example.kotlinpractise

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewMode : ViewModel() {

    var myName: MutableLiveData<String> = MutableLiveData()

    fun changeName(name: String) {
        myName.postValue(name)
    }


}
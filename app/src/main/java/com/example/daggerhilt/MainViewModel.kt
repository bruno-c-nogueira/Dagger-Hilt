package com.example.daggerhilt

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class MainViewModel @ViewModelInject constructor(): ViewModel(){
    fun showMe() = "ViewModel was instantiated with success"
}

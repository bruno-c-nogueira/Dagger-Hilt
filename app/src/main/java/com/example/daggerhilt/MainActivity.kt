package com.example.daggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        someClass.showMe()
    }
}
@AndroidEntryPoint
class MyFragment: Fragment(){

    @Inject
    lateinit var someOtherClass : SomeOtherClass
}

class SomeClass @Inject constructor(){
    fun showMe() = "I was instantiated with success"
}

@FragmentScoped
class SomeOtherClass @Inject constructor(private val someClass: SomeClass){
    fun showMe() = "I was instantiated with construct arg ${someClass.showMe()}"
}
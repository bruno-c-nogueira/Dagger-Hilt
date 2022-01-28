package com.example.daggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var someClass: SomeClass

    @Inject
    lateinit var someClass2: SomeOtherClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        someClass.showMe()
        someClass2.showMe()

    }
}


class SomeClass @Inject constructor(){
    fun showMe() = "I was instantiated with success"
}

class SomeOtherClass @Inject constructor(private val someClass: SomeClass){
    fun showMe() = "I was instantiated with construct arg ${someClass.showMe()}"
}
package com.example.daggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import dagger.Module
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
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

class SomeClass @Inject constructor(
    private val someInterface: SomeInterface,
    private val gson: Gson
    ) {
    fun showMe() = "I was instantiated with success, "
}

interface SomeInterface {
    fun getAThing(): String
}

class SomeInterfaceImpl @Inject constructor(fakeDependency: FakeDependency) : SomeInterface {
    override fun getAThing(): String {
        return "Delivering a thing"
    }
}

class FakeDependency{}




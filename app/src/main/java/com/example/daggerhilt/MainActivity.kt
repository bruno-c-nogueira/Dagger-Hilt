package com.example.daggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
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

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        someClass.showMe()
        viewModel.showMe()
    }
}

class SomeClass @Inject constructor(
    @Impl1 private val someInterface: SomeInterface,
    @Impl2 private val someInterface2: SomeInterface,
    private val gson: Gson
    ) {
    fun showMe() = "I was instantiated with success, \n${someInterface.getAThing()}\n${someInterface2.getAThing()} "
}

interface SomeInterface {
    fun getAThing(): String
}

class SomeInterfaceImpl @Inject constructor(fakeDependency: FakeDependency) : SomeInterface {
    override fun getAThing(): String {
        return "Delivering a thing"
    }
}

class SomeInterfaceImpl2 @Inject constructor(fakeDependency: FakeDependency) : SomeInterface {
    override fun getAThing(): String {
        return "Delivering a thing 2"
    }
}

class FakeDependency{}




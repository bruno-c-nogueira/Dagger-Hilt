package com.example.daggerhilt

import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class MyModule {

    @Singleton
    @Provides
    fun provideFakeDependency(): FakeDependency {
        return FakeDependency()
    }

    @Singleton
    @Provides
    fun providesGson(): Gson{
        return Gson()
    }

    @Singleton
    @Provides
    fun provideSomeInterface(fakeDependency: FakeDependency): SomeInterface {
        return SomeInterfaceImpl(fakeDependency)
    }
}
package com.example.daggerhilt

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier
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
    fun providesGson(): Gson {
        return Gson()
    }

    @Impl1
    @Singleton
    @Provides
    fun provideSomeInterface(fakeDependency: FakeDependency): SomeInterface {
        return SomeInterfaceImpl(fakeDependency)
    }

    @Impl2
    @Singleton
    @Provides
    fun provideSomeInterface2(fakeDependency: FakeDependency): SomeInterface {
        return SomeInterfaceImpl2(fakeDependency)
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Impl2

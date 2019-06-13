package com.example.baselibrary.injection.module

import android.content.Context
import com.example.baselibrary.common.BaseApplication
import com.trello.rxlifecycle2.LifecycleProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: BaseApplication) {

    @Provides
    @Singleton
    fun providesContext(): Context {
        return context
    }



}
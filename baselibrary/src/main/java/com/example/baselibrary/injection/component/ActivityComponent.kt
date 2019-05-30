package com.example.baselibrary.injection.component

import android.app.Activity
import com.example.baselibrary.injection.module.ActivityModule
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun activity(): Activity
}
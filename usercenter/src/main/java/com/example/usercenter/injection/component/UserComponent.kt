package com.example.usercenter.injection.component

import com.example.usercenter.injection.module.UserModule
import com.example.usercenter.ui.activity.RegisterActivity
import dagger.Component


@Component(modules = [UserModule::class])
interface UserComponent{
    fun inject(activity:RegisterActivity)
}
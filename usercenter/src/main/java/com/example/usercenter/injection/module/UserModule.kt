package com.example.usercenter.injection.module

import com.example.usercenter.service.UserService
import com.example.usercenter.service.impl.UserServiceImpl
import com.trello.rxlifecycle2.LifecycleProvider
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class UserModule {
    @Provides
    fun providesUserService(service:  UserServiceImpl): UserService {
        return service
    }

}
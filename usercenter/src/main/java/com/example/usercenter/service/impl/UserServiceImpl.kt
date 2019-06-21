package com.example.usercenter.service.impl

import com.example.baselibrary.ext.convert
import com.example.baselibrary.ext.convertBoolean
import com.example.baselibrary.rx.BaseFuncBoolean
import com.example.usercenter.data.protocol.ForgetRequest
import com.example.usercenter.data.protocol.UserInfo
import com.example.usercenter.data.repository.UserRepository
import com.example.usercenter.service.UserService
import io.reactivex.Observable
import javax.inject.Inject

class  UserServiceImpl @Inject constructor() : UserService {



    @Inject
    lateinit var repository: UserRepository

    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        return repository.register(mobile, pwd, verifyCode).convertBoolean()
    }
    override fun login(mobile: String, pwd: String,pushId:String): Observable<UserInfo> {
        return repository.login(mobile, pwd,pushId).convert()
    }

    override fun forget(mobile: String, pushId: String): Observable<Boolean> {
        return repository.forget(mobile,pushId).convertBoolean()
    }



}
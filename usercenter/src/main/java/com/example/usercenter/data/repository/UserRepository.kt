package com.example.usercenter.data.repository

import com.example.baselibrary.data.net.RetrofitFactory
import com.example.baselibrary.data.protocol.BaseResponse
import com.example.usercenter.data.api.UserApi
import com.example.usercenter.data.protocol.RegisterRequest
import io.reactivex.Observable
import javax.inject.Inject

class  UserRepository @Inject  constructor(){
    fun register(mobile:String, pwd:String, verifyCode:String): Observable<BaseResponse<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .register(RegisterRequest(mobile,pwd,verifyCode))
    }

}
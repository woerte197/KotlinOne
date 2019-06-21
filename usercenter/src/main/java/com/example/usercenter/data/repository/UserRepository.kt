package com.example.usercenter.data.repository

import com.example.baselibrary.data.net.RetrofitFactory
import com.example.baselibrary.data.protocol.BaseResponse
import com.example.usercenter.data.api.UserApi
import com.example.usercenter.data.protocol.ForgetRequest
import com.example.usercenter.data.protocol.LoginRequest
import com.example.usercenter.data.protocol.RegisterRequest
import com.example.usercenter.data.protocol.UserInfo
import io.reactivex.Observable
import javax.inject.Inject

class UserRepository @Inject constructor() {
    fun register(mobile: String, pwd: String, verifyCode: String): Observable<BaseResponse<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .register(RegisterRequest(mobile, pwd, verifyCode))
    }

    fun login(mobile: String, pwd: String, pushId: String): Observable<BaseResponse<UserInfo>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .login(LoginRequest(mobile, pwd, pushId))
    }

    fun forget(mobile: String, pushId: String): Observable<BaseResponse<Boolean>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .forget(ForgetRequest(mobile, pushId))
    }

}
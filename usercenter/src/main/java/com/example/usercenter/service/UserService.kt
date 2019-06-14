package com.example.usercenter.service

import com.example.usercenter.data.protocol.UserInfo
import io.reactivex.Observable


interface UserService {

    fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean>
    fun login(mobile: String, pwd: String,pushId:String): Observable<UserInfo>

}
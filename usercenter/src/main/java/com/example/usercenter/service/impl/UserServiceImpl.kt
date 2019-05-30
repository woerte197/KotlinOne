package com.example.usercenter.service.impl

import com.example.baselibrary.data.protocol.BaseResponse
import com.example.baselibrary.rx.BaseExecption
import com.example.usercenter.data.repository.UserRepository
import com.example.usercenter.service.UserService
import rx.Observable

class UserServiceImpl : UserService {
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        return UserRepository().register(mobile, pwd, verifyCode).flatMap { t: BaseResponse<String> ->
            if (t.status != 0) {
                Observable.error<Throwable>(BaseExecption(t.status, t.message))
            }
            Observable.just(true)
        }
    }


}
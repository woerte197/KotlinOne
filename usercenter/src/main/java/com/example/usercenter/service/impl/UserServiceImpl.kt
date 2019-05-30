package com.example.usercenter.service.impl

import com.example.baselibrary.data.protocol.BaseResponse
import com.example.baselibrary.rx.BaseExecption
import com.example.usercenter.data.repository.UserRepository
import com.example.usercenter.service.UserService
import rx.Observable
import javax.inject.Inject

class UserServiceImpl @Inject constructor() : UserService {
    @Inject
    lateinit var repository:UserRepository
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        return repository .register(mobile, pwd, verifyCode).flatMap { t: BaseResponse<String> ->
            if (t.status != 0) {
                Observable.error<Throwable>(BaseExecption(t.status, t.message))
            }
            Observable.just(true)
        }
    }


}
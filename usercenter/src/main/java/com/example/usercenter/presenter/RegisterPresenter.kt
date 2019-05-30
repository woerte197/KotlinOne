package com.example.usercenter.presenter

import com.example.baselibrary.ext.execute
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.rx.BaseSubscribe
import com.example.usercenter.presenter.view.RegisterView
import com.example.usercenter.service.impl.UserServiceImpl

class RegisterPresenter : BasePresenter<RegisterView>() {
    fun register(mobile: String, pwd: String, verifyCode: String) {
        /*
        * 业务逻辑
        * */
        val impl = UserServiceImpl()
        impl.register(mobile, pwd, verifyCode)
                .execute(object : BaseSubscribe<Boolean>() {
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(t)
                    }
                })
    }

}
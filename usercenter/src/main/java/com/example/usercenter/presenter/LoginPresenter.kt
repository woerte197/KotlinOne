package com.example.usercenter.presenter

import com.example.baselibrary.ext.execute
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.rx.BaseSubscribe
import com.example.usercenter.data.protocol.UserInfo
import com.example.usercenter.presenter.view.LoginView
import com.example.usercenter.service.UserService
import javax.inject.Inject

class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {
    @Inject
    lateinit var impl: UserService

    fun login(mobile: String, pwd: String, pushId: String) {
        /*
        * 业务逻辑
        * */
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        impl.login(mobile, pwd, pushId)
                .execute(object : BaseSubscribe<UserInfo>(mView) {
                    override fun onNext(t: UserInfo) {
                        mView.loginResult(t)
                    }
                }, lifecycleProvider)
    }

}
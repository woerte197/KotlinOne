package com.example.usercenter.presenter

import com.example.baselibrary.ext.execute
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.rx.BaseSubscribe
import com.example.usercenter.presenter.view.ForgetPwdView
import com.example.usercenter.service.UserService
import javax.inject.Inject

class ForgetPwdPresenter @Inject constructor() : BasePresenter<ForgetPwdView>() {

    @Inject
    lateinit var impl: UserService

    fun forget(telPhone: String, verifyCode: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        impl.forget(telPhone, verifyCode)
                .execute(object : BaseSubscribe<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        if (t) {
                            mView.onForgetResult("验证成功")
                        }
                    }
                }, lifecycleProvider)
    }

}
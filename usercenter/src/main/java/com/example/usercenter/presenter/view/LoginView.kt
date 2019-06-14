package com.example.usercenter.presenter.view

import com.example.baselibrary.presenter.view.BaseView
import com.example.usercenter.data.protocol.UserInfo

interface LoginView : BaseView {

    fun loginResult(result: UserInfo)
}
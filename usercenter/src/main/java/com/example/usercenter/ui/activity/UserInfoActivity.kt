package com.example.usercenter.ui.activity

import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.example.usercenter.R
import com.example.usercenter.injection.component.DaggerUserComponent
import com.example.usercenter.injection.module.UserModule
import com.example.usercenter.presenter.UserInfoPresenter
import com.example.usercenter.presenter.view.UserInfoView

class UserInfoActivity : BaseMvpActivity<UserInfoPresenter>(), UserInfoView {
    override fun setLayout(): Int {
        return R.layout.activity_user_info
    }

    override fun initView() {

    }

    override fun initDaggerInjection() {
        DaggerUserComponent
                .builder()
                .activityComponent(mActivityComponent)
                .userModule(UserModule())
                .build()
                .inject(this)
    }

}
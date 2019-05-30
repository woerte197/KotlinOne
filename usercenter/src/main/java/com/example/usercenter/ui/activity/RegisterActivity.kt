package com.example.usercenter.ui.activity

import android.os.Bundle
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.example.usercenter.R
import com.example.usercenter.presenter.RegisterPresenter
import com.example.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

open class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initData()
    }

    private fun initData() {
        mPresenter = RegisterPresenter()
        mPresenter.mView = this
        mLoginTv.setOnClickListener {
            mPresenter.register(mTel.text.toString(), mPassword.text.toString(), "1234")
        }
    }

    override fun onRegisterResult(result: Boolean) {
        if (result) {
            toast("登录成功")
        } else {
            toast("登录失败")
        }
    }

}

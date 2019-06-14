package com.example.usercenter.ui.activity

import android.widget.TextView
import com.example.baselibrary.ext.enable
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.example.usercenter.R
import com.example.usercenter.data.protocol.UserInfo
import com.example.usercenter.injection.component.DaggerUserComponent
import com.example.usercenter.injection.module.UserModule
import com.example.usercenter.presenter.LoginPresenter
import com.example.usercenter.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView {
    override fun setLayout(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        mLoginBtn.enable(mMobileEt) { isLoginBtnEnable() }
        mLoginBtn.enable(mPwdEt) { isLoginBtnEnable() }
        mLoginBtn.setOnClickListener {
            mPresenter.login(mMobileEt.text.toString().trim(), mPwdEt.text.toString().trim(), "123213213")
        }
        mHeaderBar.find<TextView>(R.id.mRightTv).setOnClickListener {
           startActivity<RegisterActivity>()
        }
        mForgetPwdTv.setOnClickListener {
            startActivity<ForgetPwdActivity>()
        }
    }

    override fun initDaggerInjection() {

        DaggerUserComponent.builder()
                .activityComponent(mActivityComponent)
                .userModule(UserModule())
                .build()
                .inject(this)
        mPresenter.mView = this
    }

    override fun loginResult(result: UserInfo) {

    }

    private fun isLoginBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }
}
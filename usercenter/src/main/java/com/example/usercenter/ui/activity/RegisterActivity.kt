package com.example.usercenter.ui.activity

import android.os.Bundle
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.example.usercenter.R
import com.example.usercenter.injection.component.DaggerUserComponent
import com.example.usercenter.injection.module.UserModule
import com.example.usercenter.presenter.RegisterPresenter
import com.example.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast
import kotlin.math.log10

open class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mLoginTv.setOnClickListener {
            mPresenter.register(mTel.text.toString(), mPassword.text.toString(), "1234")
        }
        mRegisterButton.setOnClickListener {
        }
    }

    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun initDaggerInjection() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

}

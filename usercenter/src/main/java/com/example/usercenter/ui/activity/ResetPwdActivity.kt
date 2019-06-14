package com.example.usercenter.ui.activity

import com.example.baselibrary.ext.enable
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.example.usercenter.R
import com.example.usercenter.injection.component.DaggerUserComponent
import com.example.usercenter.injection.module.UserModule
import com.example.usercenter.presenter.ForgetPwdPresenter
import com.example.usercenter.presenter.view.ForgetPwdView
import kotlinx.android.synthetic.main.activity_reset_pwd.*
import org.jetbrains.anko.startActivity

open class ResetPwdActivity : BaseMvpActivity<ForgetPwdPresenter>(), ForgetPwdView {


    override fun initView() {

        mConfirmBtn.enable(mPwdConfirmEt) { isRegisterBtnEnable() }
        mConfirmBtn.enable(mPwdEt) { isRegisterBtnEnable() }
        mConfirmBtn.setOnClickListener {
            startActivity<LoginActivity>()
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

    override fun onBackPressed() {
        finish()
    }

    override fun setLayout(): Int {
        return R.layout.activity_reset_pwd
    }

    private fun isRegisterBtnEnable(): Boolean {
        return mPwdConfirmEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }
}

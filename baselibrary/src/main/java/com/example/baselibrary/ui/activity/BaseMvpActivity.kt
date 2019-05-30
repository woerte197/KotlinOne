package com.example.baselibrary.ui.activity

import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.presenter.view.BaseView

open class BaseMvpActivity<T : BasePresenter<*>> :  BaseActivity(), BaseView {
    override fun showLoading() {

    }

    override fun hideLoading() {
    }

    override fun onError() {
    }

    lateinit var mPresenter: T

}
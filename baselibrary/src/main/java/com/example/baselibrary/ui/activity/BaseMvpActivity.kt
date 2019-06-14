package com.example.baselibrary.ui.activity

import android.os.Bundle
import com.example.baselibrary.common.BaseApplication
import com.example.baselibrary.injection.component.ActivityComponent
import com.example.baselibrary.injection.component.DaggerActivityComponent
import com.example.baselibrary.injection.module.ActivityModule
import com.example.baselibrary.injection.module.LifeCycleProviderModule
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.presenter.view.BaseView
import com.example.baselibrary.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    override fun showLoading() {
        mLoading.showLoading()
    }

    override fun hideLoading() {
        mLoading.hideLoading()
    }

    override fun onError(error: String) {
        toast(error)
    }

    @Inject
    lateinit var mPresenter: T
    @Inject
    lateinit var mActivityComponent: ActivityComponent

    private lateinit var mLoading: ProgressLoading


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        initActivityInjection()
        initDaggerInjection()
        mLoading = ProgressLoading.create(this)
        initView()
    }

    abstract fun setLayout(): Int

    abstract fun initView()

    abstract fun initDaggerInjection()


    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .lifeCycleProviderModule(LifeCycleProviderModule(this))
                .activityModule(ActivityModule(this))
                .build()

    }


}
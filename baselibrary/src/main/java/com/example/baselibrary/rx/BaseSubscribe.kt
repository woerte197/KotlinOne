package com.example.baselibrary.rx

import com.example.baselibrary.presenter.view.BaseView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


abstract class BaseSubscribe<T>(private val baseView: BaseView) : Observer<T> {
    override fun onComplete() {
        baseView.hideLoading()
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable) {
        baseView.hideLoading()
        baseView.onError(e.message.toString())
        if (e is BaseExecption){
        }
    }

}
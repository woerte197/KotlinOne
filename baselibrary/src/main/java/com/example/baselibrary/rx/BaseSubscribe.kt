package com.example.baselibrary.rx

import android.util.Log
import rx.Subscriber
import kotlin.math.log

open class BaseSubscribe<T> : Subscriber<T>() {

    override fun onNext(t: T) {
    }

    override fun onCompleted() {

    }

    override fun onError(e: Throwable) {
        Log.e("onError",e.message)
    }

}
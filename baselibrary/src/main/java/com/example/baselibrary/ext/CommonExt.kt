package com.example.baselibrary.ext

import com.example.baselibrary.rx.BaseSubscribe
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


fun <T> Observable<T>.execute(subscribe: BaseSubscribe<T>) {
    this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
             .subscribe(subscribe)
}


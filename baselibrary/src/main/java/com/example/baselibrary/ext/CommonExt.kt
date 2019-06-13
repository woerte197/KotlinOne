package com.example.baselibrary.ext

import android.view.View
import com.example.baselibrary.data.protocol.BaseResponse
import com.example.baselibrary.rx.BaseFunc
import com.example.baselibrary.rx.BaseFuncBoolean
import com.example.baselibrary.rx.BaseSubscribe
import com.trello.rxlifecycle2.LifecycleProvider
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun <T> Observable<T>.execute(subscribe: BaseSubscribe<T>, lifecycleProvider: LifecycleProvider<*>) {
    this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(lifecycleProvider.bindToLifecycle())
            .subscribe(subscribe)

}

fun View.OnClick(listener: View.OnClickListener) {
    this.setOnClickListener(listener)
}

fun View.OnClick(method: () -> Unit) {
    this.setOnClickListener { method() }
}

fun <T> Observable<BaseResponse<T>>.convert(): Observable<T> {
   return this.flatMap(BaseFunc())
}
fun <T> Observable<BaseResponse<T>>.convertBoolean(): Observable<Boolean> {
   return this.flatMap(BaseFuncBoolean())
}



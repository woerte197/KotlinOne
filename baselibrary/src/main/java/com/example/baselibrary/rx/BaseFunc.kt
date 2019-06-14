package com.example.baselibrary.rx

import com.example.baselibrary.data.protocol.BaseResponse
import io.reactivex.Observable
import io.reactivex.functions.Function

class  BaseFunc<T> : Function<BaseResponse<T>, Observable<T>> {
    override fun apply(t: BaseResponse<T>): Observable<T> {
        if (t.status != ResultCode.SUCCESS) {
            return Observable.error(BaseExecption(t.status, t.message))
        }
        return Observable.just(t.data)
    }


}
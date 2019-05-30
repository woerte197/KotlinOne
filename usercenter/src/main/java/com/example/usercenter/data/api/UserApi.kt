package com.example.usercenter.data.api

import com.example.baselibrary.data.protocol.BaseResponse
import com.example.usercenter.data.protocol.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface UserApi {
    @POST("usercenter/register")
    fun register(@Body request: RegisterRequest): Observable<BaseResponse<String>>


}
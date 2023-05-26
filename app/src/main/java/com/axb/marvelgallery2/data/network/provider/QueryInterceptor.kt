package com.axb.marvelgallery2.data.network.provider

import com.axb.marvelgallery2.BuildConfig
import okhttp3.Interceptor

fun makeAddSecurityQueryInterceptor() = Interceptor { chain ->
    val originalRequest = chain.request()
    val timeStamp = System.currentTimeMillis()

    // Url customization: add query parameters
    /**
     *   我们需要提供 3 个额外查询，如下所示。
     *   1. apikey：包含了当前的公钥。
     *   2.ts ： 仅包含了设备的时间（以毫秒计），用于改善下一次查询所提供的哈希值的安全性。
     *   3.hash：根据时间戳、私钥和公钥（逐一保存在独立的 String 中 〉 计算为孔。5 哈希值 。
     *
     * */
    val url = originalRequest.url.newBuilder()
        .addQueryParameter("apikey", BuildConfig.PUBLIC_KEY) // 1
        .addQueryParameter("ts", "$timeStamp") // 1
        .addQueryParameter(
            "hash",
            calculatedMd5(timeStamp.toString() + BuildConfig.PRIVATE_KEY + BuildConfig.PUBLIC_KEY)
        ) // 1
        .build()

    // Request customization: set custom url
    val request = originalRequest
        .newBuilder()
        .url(url)
        .build()

    chain.proceed(request)
}
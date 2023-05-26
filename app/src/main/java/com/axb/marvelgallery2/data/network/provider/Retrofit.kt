package com.axb.marvelgallery2.data.network.provider

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val retrofit by lazy { makeRetrofit() }

private fun makeRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("http://gateway.marvel.com/v1/public/")
        .client(makeHttpClient())
        .addConverterFactory(GsonConverterFactory.create(Gson())) // 1.添加转换器 以支持对象的 JSON 序列化操作和反序列化操作（使用 GSON 库）
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 2.针对网络请求的返回值，添加转换器以使 RxJava2 类型（包括Observable和Single）为 Observable
        .build()

private fun makeHttpClient() = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS) // 3.添加自定义拦截器，并对所有内容加以定义 。
        .readTimeout(60, TimeUnit.SECONDS) // 4
        .addInterceptor(makeHeadersInterceptor()) // 5
        .addInterceptor(makeAddSecurityQueryInterceptor()) // 6
        .addInterceptor(makeLoggingInterceptor()) // 7
        .build()

package com.test.lolinformation.di

import com.test.lolinformation.BuildConfig
import com.test.lolinformation.data.remote.api.ApiService
import com.test.lolinformation.data.remote.api.BASE_URL
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val HEADER = "header"
private const val LOGGING = "logging"
private const val TOKEN = "token"

val networkModule = module {
    single(named(HEADER)) { createHeaderInterceptor() }
    single(named(LOGGING)) { createLoggingInterceptor() }
    single { createOkHttpClient(get(named(HEADER)), get(named(LOGGING))) }
    single { createRetrofit(get()) }
    single { createApiService(get()) }
}

fun createLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().apply {
    level =
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
}

fun createHeaderInterceptor(): Interceptor = Interceptor { chain ->
    val request = chain.request()
    val newUrl = request.url.newBuilder()
        .addQueryParameter(TOKEN, BuildConfig.API_KEY)
        .build()
    val newRequest = request.newBuilder()
        .url(newUrl)
        .method(request.method, request.body)
        .build()
    chain.proceed(newRequest)
}

fun createOkHttpClient(
    header: Interceptor,
    logging: Interceptor
) = OkHttpClient.Builder()
    .addInterceptor(header)
    .addInterceptor(logging)
    .build()

fun createRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()

fun createApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

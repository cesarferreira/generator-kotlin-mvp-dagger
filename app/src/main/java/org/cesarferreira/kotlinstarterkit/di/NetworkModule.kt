package org.cesarferreira.kotlinstarterkit.di

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.cesarferreira.kotlinstarterkit.data.network.MoviesService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule(private val baseUrl: String) {

    companion object {
        const val TIMEOUT_IN_SEC: Int = 15
    }

    @Provides
    @Singleton
    internal fun provideOkHttpCache(application: Context): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10 MiB
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(cache: Cache): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.connectTimeout(TIMEOUT_IN_SEC.toLong(), TimeUnit.SECONDS)
        client.readTimeout(TIMEOUT_IN_SEC.toLong(), TimeUnit.SECONDS)
        client.cache(cache)
        return client.build()
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder().setLenient().create()
    }

    @Provides
    @Singleton
    internal fun provideRetrofitService(okHttpClient: OkHttpClient, gson: Gson): MoviesService {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        return retrofit.create(MoviesService::class.java)
    }
}

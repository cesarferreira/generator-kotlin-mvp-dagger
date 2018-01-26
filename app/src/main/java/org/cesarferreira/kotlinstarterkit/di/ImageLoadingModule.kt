package org.cesarferreira.kotlinstarterkit.di

import android.content.Context

import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module
class ImageLoadingModule {

    @Provides
    @Singleton
    internal fun providesOkHttp3Downloader(): OkHttp3Downloader {
        val client = OkHttpClient()
        return OkHttp3Downloader(client)
    }

    @Provides
    @Singleton
    internal fun providesPicasso(context: Context, okHttp3Downloader: OkHttp3Downloader): Picasso {
        return Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build()
    }
}

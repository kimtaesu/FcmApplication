package com.hucet.fcmapp.di.app

import android.app.Application
import android.os.Build
import com.hucet.fcmapp.BuildConfig
import com.hucet.fcmapp.repository.FCMRepository
import com.hucet.fcmapp.repository.ServerRepository
import com.hucet.fcmapp.service.PreferenceService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(pref: PreferenceService): OkHttpClient {
        val builder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logging)

            builder.addInterceptor({ chain ->
                fun isFCM(): Boolean {
                    return chain.request().url().toString().startsWith(BuildConfig.FCM_URL)
                }

                var req = chain.request()
                if (isFCM()) {
                    req = chain.request()
                            .newBuilder()
                            .addHeader("Authorization", "key=${BuildConfig.FCM_API_KEY}")
                            .build()
                }
                chain.proceed(req)
            })
        }

        builder.connectTimeout((60 * 1000).toLong(), TimeUnit.MILLISECONDS)
                .readTimeout((60 * 1000).toLong(), TimeUnit.MILLISECONDS)

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRestAdapter(application: Application, okHttpClient: OkHttpClient): Retrofit {
        val builder = Retrofit.Builder()
        builder.client(okHttpClient)
                .baseUrl(BuildConfig.SERVER_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
        return builder.build()
    }


    @Provides
    @Singleton
    fun provideServerRepository(restAdapter: Retrofit): ServerRepository {
        return restAdapter.create(ServerRepository::class.java!!)
    }


    @Provides
    @Singleton
    @Named("fcm")
    fun provideFCMRestAdapter(application: Application, okHttpClient: OkHttpClient): Retrofit {
        val builder = Retrofit.Builder()
        builder.client(okHttpClient)
                .baseUrl(BuildConfig.FCM_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
        return builder.build()
    }


    @Provides
    @Singleton
    fun provideFCMServerRepository(@Named("fcm") restAdapter: Retrofit): FCMRepository {
        return restAdapter.create(FCMRepository::class.java!!)
    }
}

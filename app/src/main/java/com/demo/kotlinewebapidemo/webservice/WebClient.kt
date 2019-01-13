package com.demo.kotlinewebapidemo.webservice

import com.demo.kotlinewebapidemo.Webservice
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WebClient{

    companion object Factory {
        fun create(): Webservice{
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.androidhive.info/")
                    .build()

            return retrofit.create(Webservice::class.java);
        }
    }
}

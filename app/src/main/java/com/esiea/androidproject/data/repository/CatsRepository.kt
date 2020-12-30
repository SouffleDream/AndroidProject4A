package com.esiea.androidproject.data.repository

import com.esiea.androidproject.R
import com.esiea.androidproject.data.local.CatsDataSource
import com.esiea.androidproject.data.local.models.CatModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import io.reactivex.Single

class CatsRepository (
    baseUrl: String,
    isDebugEnabled: Boolean,
    apiKey: String
) {

    private val apiKeyHeader = R.string.GOOGLE_API_KEY.toString()
    val retrofit: Retrofit

    init {

        /*adding a logging interceptor when debug is true.
        you can check how your API call is going in the LogCat */
        val loggingInterceptor = HttpLoggingInterceptor()
        if (isDebugEnabled) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        // here's how you can add your api key as a header
        val client = OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader(apiKeyHeader, apiKey)
                .build()
            chain.proceed(request)
        }.addInterceptor(loggingInterceptor)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val catsDataSource: CatsDataSource =
        CatsDataSource(retrofit)

    // a class to wrap around the response to make things easier later
    inner class Result(val netCats: List<CatModel>? = null, val errorMessage: String? = null) {

        fun hasCats(): Boolean {
            return netCats != null && !netCats.isEmpty()
        }

        fun hasError(): Boolean {
            return errorMessage != null
        }
    }

    // I want only one cat so I create a function that will get only one
    fun getNumberOfRandomCats(limit: Int, category_ids: Int?): Single<Result> {

        return catsDataSource.getNumberOfRandomCats(limit, category_ids)
            .map { netCats: List<CatModel> -> Result(netCats = netCats) }
            .onErrorReturn { t: Throwable -> Result(errorMessage = t.message) }
    }
}



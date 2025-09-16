package com.example.tweetsy_compose.api

import com.example.tweetsy_compose.models.TweetsyItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyApi {

    @GET("v3/b/68c81b73d0ea881f407eab59?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetsyItem>>

    @GET("v3/b/68c81b73d0ea881f407eab59?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getcatagoris(): Response<List<String>>
}
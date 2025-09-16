package com.example.tweetsy_compose.repository

import com.example.tweetsy_compose.api.TweetsyApi
import com.example.tweetsy_compose.models.TweetsyItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetsyRepository @Inject constructor(private val tweetsyApi: TweetsyApi) {

    private val _categories= MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    private val _tweets=MutableStateFlow<List<TweetsyItem>>(emptyList())
    val tweets: StateFlow<List<TweetsyItem>>
        get() = _tweets

    suspend fun getCategories()
    {
        val response=tweetsyApi.getcatagoris()
        if (response.isSuccessful && response.body()!=null){
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category: String)
    {
        val response=tweetsyApi.getTweets(category)
        if (response.isSuccessful && response.body()!=null){
            _tweets.emit(response.body()!!)
        }
    }
}
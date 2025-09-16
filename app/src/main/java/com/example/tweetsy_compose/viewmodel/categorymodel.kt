package com.example.tweetsy_compose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsy_compose.models.TweetsyItem
import com.example.tweetsy_compose.repository.TweetsyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class categorymodel @Inject constructor(private val repository: TweetsyRepository): ViewModel{

    val tweets: StateFlow<List<TweetsyItem>>
        get() = repository.tweets
    init {
        viewModelScope.launch {
            repository.getTweets("motivation")
        }
    }
}
package com.example.flixstercast

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flixstercast.Person
import com.example.flixstercast.RetrofitInstance
import kotlinx.coroutines.launch

class PeopleViewModel : ViewModel() {

    private val _popularPeople = MutableLiveData<List<Person>>()
    val popularPeople: LiveData<List<Person>> get() = _popularPeople

    init {
        fetchPopularPeople()
    }

    private fun fetchPopularPeople() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getPopularPeople()
                _popularPeople.postValue(response.results)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

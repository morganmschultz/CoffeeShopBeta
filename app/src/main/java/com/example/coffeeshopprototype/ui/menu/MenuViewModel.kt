package com.example.coffeeshopprototype.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Each label will have several items that will provide a description and ingredients."
    }
    val text: LiveData<String> = _text
}
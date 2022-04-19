package com.example.coffeeshopprototype.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Latte\nSmall: $3.00\nMedium: $4.50\nLarge: $5.25"
    }
    val text: LiveData<String> = _text
}
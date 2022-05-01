package com.example.coffeeshopprototype.ui.menu

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
          value = "Latte\nS: $3.00\nM: $4.50\nL: $5.25"
    }
    val text: LiveData<String> = _text
}
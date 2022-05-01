
package com.example.coffeeshopprototype.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

private const val PRICE_PER_COFFEE = 2.00
private const val PRICE_PER_LATTE = 3.50
private const val PRICE_PER_CAPPUCCINO = 3.00

private const val PRICE_FOR_MEDIUM = 1.5
private const val PRICE_FOR_LARGE = 1.75

class OrderViewModel : ViewModel() {

    // quantity is the id of the type of coffee
    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int> = _quantity

    private val _type = MutableLiveData<String>()
    val type: LiveData<String> = _type

    // coffee size for order
    private val _size = MutableLiveData<String>()
    val size: LiveData<String> = _size

    // possible date options
    val dateOptions: List<String> = getPickupOptions()

    // pickup date
    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date

    // price of the order so far
    private val _price = MutableLiveData<Double>()
    val price: LiveData<String> = Transformations.map(_price) {
        // Format the price into the local currency and return this as LiveData<String>
        NumberFormat.getCurrencyInstance().format(it)
    }

    init {

        resetOrder()
    }


    fun setQuantity(numberCoffee: Int) {
        _quantity.value = numberCoffee
        updatePrice()
    }


    fun setSize(desiredSize: String) {
        _size.value = desiredSize
        updatePrice()
    }


    fun setDate(pickupDate: String) {
        _date.value = pickupDate
        updatePrice()
    }





    fun resetOrder() {
        _quantity.value = 0
        _size.value = ""
        _date.value = dateOptions[0]
        _type.value = ""
        _price.value = 0.0
    }


    private fun updatePrice() {
        var calculatedPrice = 0.0
        //if coffee
        if(_size.value == ""){
            _size.value = "Small"
        }
        //if coffee
        if(_quantity.value == 1){
            calculatedPrice = PRICE_PER_COFFEE
            _type.value = "Black Coffee"
        }
        //if capp
        if(_quantity.value == 2){
            calculatedPrice = PRICE_PER_CAPPUCCINO
            _type.value = "Cappuccino"
        }
        //if latte
        if(_quantity.value == 3){
            calculatedPrice = PRICE_PER_LATTE
            _type.value = "Latte"
        }
        if(_size.value == "Medium"){
            calculatedPrice *= PRICE_FOR_MEDIUM
        }
        if(_size.value == "Large"){
            calculatedPrice *= PRICE_FOR_LARGE
        }
        _price.value = calculatedPrice
    }


    private fun getPickupOptions(): List<String> {
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("h:mm a", Locale.getDefault())
        val calendar = Calendar.getInstance()
        repeat(4) {

            calendar.add(Calendar.AM_PM+1, 1)
            options.add(formatter.format(calendar.time))
        }
        return options
    }
}
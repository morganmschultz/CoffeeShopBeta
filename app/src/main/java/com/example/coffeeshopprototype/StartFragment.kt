
package com.example.coffeeshopprototype

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.coffeeshopprototype.model.OrderViewModel
import com.example.coffeeshopprototype.R
import com.example.coffeeshopprototype.databinding.FragmentStartBinding


class StartFragment : Fragment() {

    // Binding object instance corresponding to the fragment_start.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private var binding: FragmentStartBinding? = null

    // Use the 'by activityViewModels()' Kotlin property delegate from the fragment-ktx artifact
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.startFragment = this
    }


    fun orderCoffee(quantity: Int) {
        //quanitity is the id of the item (1=coffee, 2=capp, 3 = latte)
        sharedViewModel.setQuantity(1)


        findNavController().navigate(R.id.action_startFragment_to_sizeFragment)
    }

    fun orderCappuccino(quantity: Int) {
        sharedViewModel.setQuantity(2)



        findNavController().navigate(R.id.action_startFragment_to_sizeFragment)
    }

    fun orderLatte(quantity: Int) {
        sharedViewModel.setQuantity(3)



        findNavController().navigate(R.id.action_startFragment_to_sizeFragment)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
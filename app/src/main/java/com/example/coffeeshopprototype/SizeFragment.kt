
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
import com.example.coffeeshopprototype.databinding.FragmentSizeBinding

class SizeFragment : Fragment() {


    private var binding: FragmentSizeBinding? = null

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSizeBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            // Specify the fragment as the lifecycle owner
            lifecycleOwner = viewLifecycleOwner

            // Assign the view model to a property in the binding class
            viewModel = sharedViewModel

            // Assign the fragment
            sizeFragment = this@SizeFragment
        }
    }


    fun goToNextScreen() {
        findNavController().navigate(R.id.action_sizeFragment_to_pickupFragment)
    }

    fun cancelOrder() {
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_sizeFragment_to_startFragment)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
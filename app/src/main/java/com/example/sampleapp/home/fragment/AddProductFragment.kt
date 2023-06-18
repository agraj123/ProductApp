package com.example.sampleapp.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.sampleapp.R
import com.example.sampleapp.databinding.FragmentAddProductBinding
import com.example.sampleapp.home.data.AddPostModel
import com.example.sampleapp.home.data.PostModel
import com.example.sampleapp.home.viewmodel.HomeViewModel
import com.example.sampleapp.utils.EventObserver
import com.example.sampleapp.utils.Resource

class AddProductFragment : Fragment() {

    lateinit var binding: FragmentAddProductBinding
    private lateinit var vm: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddProductBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this)[HomeViewModel::class.java]
        var name = ""
        var price = ""
        var type = ""
        var tax = ""

        binding.addProductBtn.setOnClickListener {
            name = binding.tvName.text.toString().trim()
            price = binding.tvPrice.text.toString().trim()
            type = binding.tvType.text.toString().trim()
            tax = binding.tvTax.text.toString().trim()

            if (name.isNotEmpty() && price.isNotEmpty() && type.isNotEmpty() && tax.isNotEmpty()) {
                val postModel = AddPostModel(
                    name, price, type, tax
                )
                vm.addProduct(postModel)

            } else {
                showToast("Please fill all data!")
            }
        }
        vm.addData.observe(viewLifecycleOwner, EventObserver {
            when (it) {
                is Resource.Loading -> {

                }

                is Resource.Success -> {
                    it.data?.message?.let { it1 -> showToast(it1) }
                }

                is Resource.Error -> {
                    it.data?.message?.let { it1 -> showToast(it1) }
                }
            }
        })
    }

    private fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}
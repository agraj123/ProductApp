package com.example.sampleapp.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleapp.R
import com.example.sampleapp.databinding.FragmentListProductBinding
import com.example.sampleapp.home.data.PostModel
import com.example.sampleapp.home.ui.HomeAdapter
import com.example.sampleapp.home.viewmodel.HomeViewModel

class ListProductFragment : Fragment() {

    lateinit var binding: FragmentListProductBinding
    private lateinit var vm: HomeViewModel
    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListProductBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this)[HomeViewModel::class.java]

        initAdapter()

        vm.fetchAllProducts()

        vm.postModelListLiveData?.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                binding.rvHome.visibility = View.VISIBLE
                adapter.setData(it as ArrayList<PostModel>)
            } else {
                showToast("Something went wrong")
            }
            binding.progressHome.visibility = View.GONE
        })

        binding.addBtn.setOnClickListener {
            findNavController().navigate(R.id.action_listProductFragment_to_addProductFragment)
        }

    }

    private fun initAdapter() {
        adapter = HomeAdapter()
        binding.rvHome.layoutManager = LinearLayoutManager(context)
        binding.rvHome.adapter = adapter
    }


    private fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

}
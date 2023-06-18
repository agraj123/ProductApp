package com.example.sampleapp.home.ui

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleapp.R
import com.example.sampleapp.databinding.ActivityMainBinding
import com.example.sampleapp.home.data.PostModel
import com.example.sampleapp.home.viewmodel.HomeViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    /*private lateinit var vm: HomeViewModel
    private lateinit var adapter: HomeAdapter*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       /* vm = ViewModelProvider(this)[HomeViewModel::class.java]

        initAdapter()

        vm.fetchAllPosts()

        vm.postModelListLiveData?.observe(this, Observer {
            if (it!=null){
                binding.rvHome.visibility = View.VISIBLE
                adapter.setData(it as ArrayList<PostModel>)
            }else{
                showToast("Something went wrong")
            }
            binding.progressHome.visibility = View.GONE
        })
*/
    }


    /*private fun showCreatePOstDialog() {
        val dialog = Dialog(this)
        val view = LayoutInflater.from(this).inflate(R.layout.create_post_dialog, null)
        dialog.setContentView(view)

        var title = ""
        var body = ""

        view.btn_submit.setOnClickListener {
            title = view.et_title.text.toString().trim()
            body = view.et_body.text.toString().trim()

            if (title.isNotEmpty() && body.isNotEmpty()){
                val postModel = PostModel()
                postModel.userId = 1
                postModel.title = title
                postModel.body = body

                vm.createPost(postModel)

                vm.createPostLiveData?.observe(this, Observer {
                    if (it!=null){
                        adapter.addData(postModel)
                        rv_home.smoothScrollToPosition(0)
                    }else{
                        showToast("Cannot create post at the moment")
                    }
                    dialog.cancel()
                })

            }else{
                showToast("Please fill data carefully!")
            }

        }

        dialog.show()

        val window = dialog.window
        window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

    }*/

    /*private fun initAdapter() {
        adapter = HomeAdapter()
        binding.rvHome.layoutManager = LinearLayoutManager(this)
        binding.rvHome.adapter = adapter
    }


    private fun showToast(msg:String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }*/

}

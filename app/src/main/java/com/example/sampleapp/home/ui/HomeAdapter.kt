package com.example.sampleapp.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sampleapp.R
import com.example.sampleapp.databinding.HomeRvItemViewBinding
import com.example.sampleapp.home.data.PostModel
import java.util.Locale


/*
class HomeAdapter() :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var data: ArrayList<PostModel>? = null

    fun setData(list: ArrayList<PostModel>) {
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.home_rv_item_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bind(item)
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: PostModel?) {
            itemView.tv_home_item_title.text = item?.product_name
            itemView.tv_home_item_body.text = item?.price
        }

    }

}*/
class HomeAdapter() :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var data: ArrayList<PostModel>? = null
    private val arraylist: ArrayList<PostModel>? = null

    fun setData(list: ArrayList<PostModel>) {
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HomeRvItemViewBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = data?.get(position)
        if (product != null) {
            holder.bind(product)
        }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

//    fun filter(charText: String) {
//        var charText = charText
//        charText = charText.lowercase(Locale.getDefault())
//        data!!.clear()
//        if (charText.isEmpty()) {
//            if (arraylist != null) {
//                data!!.addAll(arraylist)
//            }
//        } else {
//            if (arraylist != null) {
//                for (wp in arraylist) {
//                    if (wp.product_name!!.toLowerCase(Locale.getDefault()).contains(charText)) {
//                        arraylist.add(wp)
//                    }
//                }
//            }
//        }
//        notifyDataSetChanged()
//    }

    class ViewHolder(private val binding: HomeRvItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: PostModel) {
            binding.tvHomeItemTitle.text = "Name: " + product.product_name
            binding.tvHomeItemPrice.text = "Price: " + product.price
            binding.tvHomeItemTax.text = "Tax: " + product.tax
            binding.tvHomeItemType.text = "Type: " + product.product_type
            if (product.image?.isNotEmpty() == true) {
                Glide.with(itemView.context)
                    .load(product.image) // Replace imageUrl with the actual URL or image resource
                    .into(binding.image) // Replace imageView with your actual ImageView
            } else {
                binding.image.setImageResource(R.drawable.baseline_android_24)
            }
        }
    }
}
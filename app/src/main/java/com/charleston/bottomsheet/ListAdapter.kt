package com.charleston.bottomsheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


internal class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBindData()
    }

    override fun getItemCount(): Int {
        return 10
    }

    internal inner class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        var imageView: ImageView = itemView.findViewById(R.id.image)

        fun onBindData() {
            Glide.with(imageView.context)
                .load("https://gizmodo.uol.com.br/wp-content/blogs.dir/8/files/2019/08/android-10-google.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView)

        }
    }
}

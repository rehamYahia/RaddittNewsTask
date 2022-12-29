package com.example.redditnews.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.radditnews2.R
import com.example.radditnews2.model.Children
import com.example.radditnews2.model.DataX
import com.squareup.picasso.Picasso


class ArticleAdapter() : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>(){

    var items = ArrayList<Children>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(items:ArrayList<Children>){
        this.items = items
        notifyDataSetChanged()

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.articleitem , parent , false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ArticleViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.title)
//        val imageURL = itemView.findViewById<ImageView>(R.id.image)
        fun bind(child:Children){
            title.text = child.data.title
//            val url = child.data.media.oembed.thumbnail_url
//            Picasso.get()
//                .load(url)
//                .into(imageURL)
        }
    }


 }
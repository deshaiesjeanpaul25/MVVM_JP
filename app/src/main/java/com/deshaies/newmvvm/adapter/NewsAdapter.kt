package com.deshaies.newmvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.deshaies.newmvvm.R
import com.deshaies.newmvvm.data.Articles

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    private var news: List<Articles> = emptyList()

    fun updateData(news: List<Articles>) {
        this.news = news
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = news[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(article: Articles){

            itemView.findViewById<TextView>(R.id.title).text = article.title
            itemView.findViewById<TextView>(R.id.description).text = article.description

            val image : ImageView =itemView.findViewById<ImageView>(R.id.image)

            Glide.with(itemView)
                .load(article.urlToImage)
                .into(image)
        }
    }
}

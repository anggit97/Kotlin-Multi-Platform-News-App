package com.anggitprayogo.kotlinmultiplatformproject.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.anggitprayogo.kotlinmultiplatformproject.R
import domain.model.Article
import kotlinx.android.synthetic.main.row_item_news.view.*

class MainActivityAdapter : RecyclerView.Adapter<MainActivityAdapter.ViewHolder>() {

    private var newsList: MutableList<Article> = mutableListOf()

    fun setItems(newsList: MutableList<Article>) {
        this.newsList = newsList
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(article: Article) {
            with(itemView) {
                ivNews.load(article.urlToImage)
                tvTitleNews.text = article.title
                tvAuthorNews.text = article.author
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_item_news,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(newsList[position])
    }
}
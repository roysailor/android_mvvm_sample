package com.medleyone.news.home.view.adapters

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.medleyone.news.R
import com.medleyone.news.home.data.model.Article
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation


class ArticleListAdapter(private val articles: MutableList<Article>): RecyclerView.Adapter<ArticleViewHolder>(){

    fun setArticles(articles: List<Article>){

        this.articles.clear()
        this.articles.addAll(articles)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_article_view_holder, parent, false)

        return ArticleViewHolder(view)

    }

    override fun getItemCount(): Int {

        return articles.size

    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        var article = articles[position]

        holder.tvHeadline.text = article.title

        var transformation: Transformation = object : Transformation {

            override fun transform(source: Bitmap): Bitmap? {

                val targetWidth: Int = holder.ivArticle.getWidth()
                val aspectRatio = source.height.toDouble() / source.width.toDouble()
                val targetHeight = (targetWidth * aspectRatio).toInt()
                val result = Bitmap.createScaledBitmap(source, targetWidth, targetHeight, false)

                if (result != source) {
                    source.recycle()
                }

                return result
            }

            override  fun key(): String? {
                return "transformation" + " desiredWidth"
            }
        }

        Picasso.get().load(article.urlToImage).transform(transformation).into(holder.ivArticle)

        holder.tvSource.text = article.source.name
        holder.tvDate.text = article.publishedAt

    }



}
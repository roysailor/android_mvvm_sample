package com.medleyone.news.home.view.adapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.medleyone.news.R

class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    val tvHeadline = itemView.findViewById(R.id.tvHeadline) as TextView
    val ivArticle = itemView.findViewById(R.id.ivArticle) as ImageView
    val tvSource = itemView.findViewById(R.id.tvSource) as TextView
    val tvDate = itemView.findViewById(R.id.tvDate) as TextView

}
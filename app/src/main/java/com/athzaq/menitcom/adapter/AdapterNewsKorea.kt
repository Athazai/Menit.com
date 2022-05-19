package com.athzaq.menitcom.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.athzaq.menitcom.activity.detailactivity.DetailNewsKoreaSelatanActivity
import com.athzaq.menitcom.activity.detailactivity.DetailNewsOlahragaaActivity
import com.athzaq.menitcom.databinding.ItemRecyclerKoreaBinding
import com.athzaq.menitcom.model.ArticlesItem

class AdapterNewsKorea : RecyclerView.Adapter<AdapterNewsKorea.ViewHolder>() {

    private val listberita : ArrayList<ArticlesItem> = arrayListOf()
    @SuppressLint("NotifyDataSetChanged")
    fun addDataNewsKorea(ngambildata : List<ArticlesItem>){
        listberita.clear()
        listberita.addAll(ngambildata)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding : ItemRecyclerKoreaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRecyclerKoreaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listArticlesItem = listberita[position]

        holder.binding.txtTitlekorea.text = listArticlesItem.title
        holder.binding.txtAuthorkorea.text = listArticlesItem.author
        holder.binding.txtPublishedkorea.text = listArticlesItem.publishedAt
        holder.binding.imgKorea.load(listArticlesItem.urlToImage)

        holder.itemView.setOnClickListener {
            val pergi = Intent(it.context,DetailNewsKoreaSelatanActivity::class.java)
            pergi.putExtra(DetailNewsKoreaSelatanActivity.PublishedAt, listArticlesItem.publishedAt)
            pergi.putExtra(DetailNewsKoreaSelatanActivity.Author, listArticlesItem.author)
            pergi.putExtra(DetailNewsKoreaSelatanActivity.UrlImage, listArticlesItem.urlToImage)
            pergi.putExtra(DetailNewsKoreaSelatanActivity.Description, listArticlesItem.description)
            pergi.putExtra(DetailNewsKoreaSelatanActivity.Title, listArticlesItem.title)
            pergi.putExtra(DetailNewsKoreaSelatanActivity.Content, listArticlesItem.content)
            it.context.startActivity(pergi)
        }

    }

    override fun getItemCount() = listberita.size
}
package com.athzaq.menitcom.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.athzaq.menitcom.activity.detailactivity.DetailNewsKoreaSelatanActivity
import com.athzaq.menitcom.activity.detailactivity.DetailNewsMesirActivity
import com.athzaq.menitcom.databinding.ItemRecyclerArabBinding
import com.athzaq.menitcom.model.ArticlesItem

class AdapterNewsArab() : RecyclerView.Adapter<AdapterNewsArab.ViewHolder>() {

    private val listberita : ArrayList<ArticlesItem> = arrayListOf()
    @SuppressLint("NotifyDataSetChanged")
    fun addDataNewsArab(ngambildata : List<ArticlesItem>){
        listberita.clear()
        listberita.addAll(ngambildata)
        notifyDataSetChanged()
    }
    class ViewHolder(var binding : ItemRecyclerArabBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRecyclerArabBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listArticles = listberita[position]

        holder.binding.txtTitlearab.text = listArticles.title
        holder.binding.txtAuthorarab.text = listArticles.author
        holder.binding.txtPublishedarab.text = listArticles.publishedAt
        holder.binding.imgArab.load(listArticles.urlToImage){
            scale(coil.size.Scale.FIT)
        }

        holder.itemView.setOnClickListener {
            val pergi = Intent(it.context, DetailNewsMesirActivity::class.java)
            pergi.putExtra(DetailNewsMesirActivity.PublishedAt, listArticles.publishedAt)
            pergi.putExtra(DetailNewsMesirActivity.Author, listArticles.author)
            pergi.putExtra(DetailNewsMesirActivity.UrlImage, listArticles.urlToImage)
            pergi.putExtra(DetailNewsMesirActivity.Description, listArticles.description)
            pergi.putExtra(DetailNewsMesirActivity.Title, listArticles.title)
            pergi.putExtra(DetailNewsMesirActivity.Content, listArticles.content)
            it.context.startActivity(pergi)
        }
    }
    override fun getItemCount() = listberita.size
}
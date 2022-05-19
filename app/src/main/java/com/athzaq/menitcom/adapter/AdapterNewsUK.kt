package com.athzaq.menitcom.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.athzaq.menitcom.activity.detailactivity.DetailNewsUKActivity
import com.athzaq.menitcom.databinding.ItemRecyclerUkBinding
import com.athzaq.menitcom.model.ArticlesItem

class AdapterNewsUK : RecyclerView.Adapter<AdapterNewsUK.ViewHolder>(){

    private val listnews : ArrayList<ArticlesItem> = arrayListOf()
    @SuppressLint("NotifyDataSetChanged")
    fun addDataNews(xmmambildata : List<ArticlesItem>){
        listnews.clear()
        listnews.addAll(xmmambildata)
        notifyDataSetChanged()
    }
    class ViewHolder(var binding: ItemRecyclerUkBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerUkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataartikelberita = listnews[position]

        holder.binding.txtTitleUK.text = dataartikelberita.title
        holder.binding.txtAuthorUK.text = dataartikelberita.author
        holder.binding.txtPublishedUK.text = dataartikelberita.publishedAt
        holder.binding.imgUK.load(dataartikelberita.urlToImage){
            scale(Scale.FILL)
        }
        holder.itemView.setOnClickListener {
            val pergi = Intent(it.context, DetailNewsUKActivity::class.java)
            pergi.putExtra(DetailNewsUKActivity.PublishedAt, dataartikelberita.publishedAt)
            pergi.putExtra(DetailNewsUKActivity.Author, dataartikelberita.author)
            pergi.putExtra(DetailNewsUKActivity.UrlImage, dataartikelberita.urlToImage)
            pergi.putExtra(DetailNewsUKActivity.Description, dataartikelberita.description)
            pergi.putExtra(DetailNewsUKActivity.Title, dataartikelberita.title)
            pergi.putExtra(DetailNewsUKActivity.Content, dataartikelberita.content)
        }
    }

    override fun getItemCount() = listnews.size
}
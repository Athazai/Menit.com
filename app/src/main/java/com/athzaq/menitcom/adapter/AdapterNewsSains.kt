package com.athzaq.menitcom.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.athzaq.menitcom.databinding.ItemRecyclerSainsBinding
import com.athzaq.menitcom.model.ArticlesItem

class AdapterNewsSains : RecyclerView.Adapter<AdapterNewsSains.ViewHolder>() {

    private val listberita : ArrayList<ArticlesItem> = arrayListOf()
    @SuppressLint("NotifyDataSetChanged")
    fun addDataSainsNews(zaidanngambildata : List<ArticlesItem>){
        listberita.clear()
        listberita.addAll(zaidanngambildata)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding : ItemRecyclerSainsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRecyclerSainsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataArtikelSains = listberita[position]

        holder.binding.txtTitlesains.text = dataArtikelSains.title
        holder.binding.txtAuthorsains.text = dataArtikelSains.author
        holder.binding.txtPublishedsains.text = dataArtikelSains.publishedAt
        holder.binding.imgSains.load(dataArtikelSains.urlToImage)


    }

    override fun getItemCount() = listberita.size
}
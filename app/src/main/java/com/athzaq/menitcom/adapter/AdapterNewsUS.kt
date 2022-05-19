package com.athzaq.menitcom.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.athzaq.menitcom.activity.detailactivity.DetailNewsUSActivity
import com.athzaq.menitcom.databinding.ItemRecyclerUsBinding
import com.athzaq.menitcom.model.ArticlesItem

class AdapterNewsUS : RecyclerView.Adapter<AdapterNewsUS.ViewHolder>(){

    private val listnews : ArrayList<ArticlesItem> = arrayListOf()
    @SuppressLint("NotifyDataSetChanged")
    fun addDataNews(xtkjambildata : List<ArticlesItem>){
        listnews.clear()
        listnews.addAll(xtkjambildata)
        notifyDataSetChanged()
    }
    class ViewHolder(var binding : ItemRecyclerUsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRecyclerUsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataartikelberita = listnews[position]

        holder.binding.txtTitleUS.text = dataartikelberita.title
        holder.binding.txtAuthorUS.text = dataartikelberita.author
        holder.binding.txtPublishedUS.text = dataartikelberita.publishedAt
        holder.binding.imgNewsUS.load(dataartikelberita.urlToImage){
            scale(Scale.FILL)
        }
        holder.itemView.setOnClickListener {
            val pergi = Intent(it.context, DetailNewsUSActivity::class.java)
            pergi.putExtra(DetailNewsUSActivity.PublishedAt, dataartikelberita.publishedAt)
            pergi.putExtra(DetailNewsUSActivity.Author, dataartikelberita.author)
            pergi.putExtra(DetailNewsUSActivity.UrlImage, dataartikelberita.urlToImage)
            pergi.putExtra(DetailNewsUSActivity.Description, dataartikelberita.description)
            pergi.putExtra(DetailNewsUSActivity.Title, dataartikelberita.title)
            pergi.putExtra(DetailNewsUSActivity.Content, dataartikelberita.content)
            it.context.startActivity(pergi)
        }
    }

    override fun getItemCount() = listnews.size
}
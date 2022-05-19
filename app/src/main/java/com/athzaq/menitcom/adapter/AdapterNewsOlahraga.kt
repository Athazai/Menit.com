package com.athzaq.menitcom.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.athzaq.menitcom.activity.detailactivity.DetailNewsOlahragaaActivity
import com.athzaq.menitcom.databinding.ItemRecyclerOlahragaBinding
import com.athzaq.menitcom.model.ArticlesItem

class AdapterNewsOlahraga : RecyclerView.Adapter<AdapterNewsOlahraga.ViewHolder>() {

    private val listberita : ArrayList<ArticlesItem> = arrayListOf()
    @SuppressLint("NotifyDataSetChanged")
    fun addDataEntertaimentNews(athallahngambildata : List<ArticlesItem>){
        listberita.clear()
        listberita.addAll(athallahngambildata)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding : ItemRecyclerOlahragaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRecyclerOlahragaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataArtikelNews = listberita[position]

        holder.binding.txtTitleentertaiment.text = dataArtikelNews.title
        holder.binding.txtAuthorentertaiment.text = dataArtikelNews.author
        holder.binding.txtPublishedentertaiment.text = dataArtikelNews.publishedAt
        holder.binding.imgEntertaiment.load(dataArtikelNews.urlToImage){
            scale(coil.size.Scale.FILL)
        }

        holder.itemView.setOnClickListener {
            val pergi = Intent(it.context, DetailNewsOlahragaaActivity::class.java)
            pergi.putExtra(DetailNewsOlahragaaActivity.PublishedAt, dataArtikelNews.publishedAt)
            pergi.putExtra(DetailNewsOlahragaaActivity.Author, dataArtikelNews.author)
            pergi.putExtra(DetailNewsOlahragaaActivity.UrlImage, dataArtikelNews.urlToImage)
            pergi.putExtra(DetailNewsOlahragaaActivity.Description, dataArtikelNews.description)
            pergi.putExtra(DetailNewsOlahragaaActivity.Title, dataArtikelNews.title)
            pergi.putExtra(DetailNewsOlahragaaActivity.Content, dataArtikelNews.content)
            it.context.startActivity(pergi)
        }
    }

    override fun getItemCount() = listberita.size
}
package com.athzaq.menitcom.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.athzaq.menitcom.activity.detailactivity.DetailNewsBisnisActivity
import com.athzaq.menitcom.databinding.ItemRecyclerBisnisBinding
import com.athzaq.menitcom.model.ArticlesItem

class AdapterNewsBisnis : RecyclerView.Adapter<AdapterNewsBisnis.ViewHolder>() {

    private val listberita : ArrayList<ArticlesItem> = arrayListOf()
    @SuppressLint("NotifyDataSetChanged")
    fun addDataBerita(athangambildata : List<ArticlesItem>){
        listberita.clear()
        listberita.addAll(athangambildata)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: ItemRecyclerBisnisBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRecyclerBisnisBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataartikelnews = listberita[position]

        holder.binding.txtTitlebisnis.text = dataartikelnews.title
        holder.binding.txtAuthorbisnis.text = dataartikelnews.author
        holder.binding.txtPublishedbisnis.text = dataartikelnews.publishedAt
        holder.binding.imgBisnis.load(dataartikelnews.urlToImage){
            scale(Scale.FILL)
        }

        holder.itemView.setOnClickListener {
            val pergi = Intent(it.context, DetailNewsBisnisActivity::class.java)
            pergi.putExtra(DetailNewsBisnisActivity.PublishedAt, dataartikelnews.publishedAt)
            pergi.putExtra(DetailNewsBisnisActivity.Author, dataartikelnews.author)
            pergi.putExtra(DetailNewsBisnisActivity.UrlImage, dataartikelnews.urlToImage)
            pergi.putExtra(DetailNewsBisnisActivity.Description, dataartikelnews.description)
            pergi.putExtra(DetailNewsBisnisActivity.Title, dataartikelnews.title)
            pergi.putExtra(DetailNewsBisnisActivity.Content, dataartikelnews.content)
            it.context.startActivity(pergi)
        }
}
    override fun getItemCount() = listberita.size

}
package com.athzaq.menitcom.adapter


import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.athzaq.menitcom.activity.detailactivity.DetailNewsIndoActivity
import com.athzaq.menitcom.databinding.ItemRecyclerIndoBinding
import com.athzaq.menitcom.model.ArticlesItem

class AdapterNewsIndo(private val listnews : ArrayList<ArticlesItem> = arrayListOf()) : RecyclerView.Adapter<AdapterNewsIndo.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun addDataNews(xrplngambildata : List<ArticlesItem>){
        listnews.clear()
        listnews.addAll(xrplngambildata)
        notifyDataSetChanged()

    }
    class ViewHolder(var binding: ItemRecyclerIndoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecyclerIndoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataartikelberita  = listnews[position]

        holder.binding.txtTitledetail.text = dataartikelberita.title
        holder.binding.txtAuthordetal.text = dataartikelberita.author
        holder.binding.txtPublished.text = dataartikelberita.publishedAt
        holder.binding.imgDetail.load(dataartikelberita.urlToImage!!){
            scale(Scale.FILL)
        }
        holder.itemView.setOnClickListener {
            val pergi = Intent(it.context, DetailNewsIndoActivity::class.java)
            pergi.putExtra(DetailNewsIndoActivity.PublishedAt, dataartikelberita.publishedAt)
            pergi.putExtra(DetailNewsIndoActivity.Author, dataartikelberita.author)
            pergi.putExtra(DetailNewsIndoActivity.UrlImage, dataartikelberita.urlToImage)
            pergi.putExtra(DetailNewsIndoActivity.Description, dataartikelberita.description)
            pergi.putExtra(DetailNewsIndoActivity.Title, dataartikelberita.title)
            pergi.putExtra(DetailNewsIndoActivity.Content, dataartikelberita.content)
            it.context.startActivity(pergi)
        }
    }
    override fun getItemCount() = listnews.size
}

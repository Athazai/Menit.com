package com.athzaq.menitcom.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.athzaq.menitcom.databinding.ActivityDataProvinsiCovidBinding
import com.athzaq.menitcom.databinding.ItemRecyclerDataprovinsiBinding
import com.athzaq.menitcom.model.DataItem

class AdapterDataCovidProvinsi (private val listProv : ArrayList<DataItem> = arrayListOf()) : RecyclerView.Adapter<AdapterDataCovidProvinsi.ViewHolder>() {

    @SuppressLint("NotifiSetDataChanged")
    fun addDataProv(athangambildata : List<DataItem>){
        listProv.clear()
        listProv.addAll(athangambildata)
        notifyDataSetChanged()

    }
    class ViewHolder (var binding: ItemRecyclerDataprovinsiBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRecyclerDataprovinsiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataprovinsi = listProv[position]

        holder.binding.txtNamaProvinsicovid.text = dataprovinsi.provinsi
        holder.binding.txtMeninggalcovidProvinsi.text = dataprovinsi.kasusMeni
        holder.binding.txtSembuhcovidProvinsi.text = dataprovinsi.kasusSemb
        holder.binding.txtPositifcovidProvinsi.text = dataprovinsi.kasusPosi
    }

    override fun getItemCount() = listProv.size
}
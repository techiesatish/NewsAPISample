package com.reposenergy.ui.adapter


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reposenergy.data.models.Article
import com.reposenergy.databinding.RecyclerItemsBinding
import com.reposenergy.listeners.OnNewsItemClick
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class NewsAdapter(var context: Context,var newsItemClick: OnNewsItemClick): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    var list=ArrayList<Article>()
    var formatPattern = "yyyy-MM-dd'T'HH:mm:ss"

    class ViewHolder(val binding:RecyclerItemsBinding): RecyclerView.ViewHolder(binding.root) {
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RecyclerItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(list.get(position).urlToImage).into(holder.binding.imgNews)
        holder.binding.tvPostDetails.text=list.get(position).description
        holder.binding.tvPostHeading.text=list.get(position).title
        holder.binding.tvSource.text=list.get(position).source?.name
        var formattedTime=setTime(list.get(position).publishedAt)
        holder.binding.tvTimestamp.text=formattedTime
        holder.itemView.setOnClickListener(View.OnClickListener {
            newsItemClick.onNewsItemClick(list.get(position))
        })

    }
    fun setTime(date:String?):String{ //Converting local Time
        val simpleDateFormat = SimpleDateFormat(formatPattern)
        simpleDateFormat.timeZone = TimeZone.getTimeZone("GMT")
        val outputDate = SimpleDateFormat("HH:mm dd/MM/yyyy")
        outputDate.timeZone = TimeZone.getDefault()
        var fromTime= simpleDateFormat.parse(date)
        var toTime= outputDate.format(fromTime!!)
        return toTime.toString()
    }
    fun updateList(list:List<Article>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}
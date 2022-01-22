package com.mbamgn.moviecatalogue.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mbamgn.moviecatalogue.R
import com.mbamgn.moviecatalogue.databinding.ItemListTvShowBinding
import com.mbamgn.moviecatalogue.model.DataItem
import com.mbamgn.moviecatalogue.ui.detail.DetailActivity

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private val listTvShow = ArrayList<DataItem>()

    fun setTvShow(data: List<DataItem>) {
        this.listTvShow.apply {
            clear()
            addAll(data)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TvShowAdapter.TvShowViewHolder {
        val view = ItemListTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowAdapter.TvShowViewHolder, position: Int) =
        holder.bind(listTvShow[position])

    override fun getItemCount(): Int = listTvShow.size

    inner class TvShowViewHolder(private val binding: ItemListTvShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataItem) {
            binding.apply {
                tvListTitleTvShow.text = data.title
                tvListReleaseDateTvShow.text = data.releaseDate
                tvListDescTvShow.text = data.desc

                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${data.poster}")
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_eror)
                    .into(imgListPosterTvShow)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ID, data.id)
                    itemView.context.startActivity(intent)
                }

            }
        }
    }

}
package com.mbamgn.moviecatalogue.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mbamgn.moviecatalogue.R
import com.mbamgn.moviecatalogue.data.TvShowEntity
import com.mbamgn.moviecatalogue.databinding.ItemListTvShowBinding
import com.mbamgn.moviecatalogue.ui.detail_tv_show.DetailTvShowActivity

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private val listTvShow = ArrayList<TvShowEntity>()

    fun setTvShow(data: List<TvShowEntity>) {
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
        fun bind(data: TvShowEntity) {
            binding.apply {
                tvListTitleTvShow.text = data.title
                tvListDurationTvShow.text = data.duration
                tvListGenreTvShow.text = data.genre

                Glide.with(itemView.context)
                    .load(data.img)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_eror)
                    .into(imgListPosterTvShow)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java)
                    intent.putExtra(DetailTvShowActivity.EXTRA_ID, data.tvShowId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

}
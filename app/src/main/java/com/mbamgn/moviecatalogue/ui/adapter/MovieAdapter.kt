package com.mbamgn.moviecatalogue.ui.adapter

import android.content.Intent
import android.nfc.NfcAdapter.EXTRA_ID
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mbamgn.moviecatalogue.R
import com.mbamgn.moviecatalogue.databinding.ItemListMovieBinding
import com.mbamgn.moviecatalogue.model.DataItem
import com.mbamgn.moviecatalogue.ui.detail.DetailActivity
import com.mbamgn.moviecatalogue.ui.diffcallback.MovieDiffCallback

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val listMovie = ArrayList<DataItem>()

    fun setMovieData(data: List<DataItem>) {
        val diffCallback = MovieDiffCallback(this.listMovie, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listMovie.apply {
            clear()
            addAll(data)
        }
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MovieAdapter.MovieViewHolder {
        val view = ItemListMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) =
        holder.bind(listMovie[position])

    override fun getItemCount(): Int = listMovie.size

    inner class MovieViewHolder(private val binding: ItemListMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: DataItem) {
            binding.apply {
                tvListTitleMovie.text = data.title
                tvListReleaseDateMovie.text = data.releaseDate
                tvListDescMovie.text = data.desc

                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${data.poster}")
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_eror)
                    .into(imgListPosterMovie)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ID, data.id)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}
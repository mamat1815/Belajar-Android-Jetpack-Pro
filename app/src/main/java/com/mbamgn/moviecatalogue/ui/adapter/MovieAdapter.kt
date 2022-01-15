package com.mbamgn.moviecatalogue.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mbamgn.moviecatalogue.R
import com.mbamgn.moviecatalogue.data.MovieEntity
import com.mbamgn.moviecatalogue.databinding.ItemListMovieBinding
import com.mbamgn.moviecatalogue.ui.detail_movie.DetailMovieActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val listMovie = ArrayList<MovieEntity>()

    fun setMovieData(data: List<MovieEntity>) {
        this.listMovie.apply {
            clear()
            addAll(data)
        }
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

        fun bind(movie: MovieEntity) {
            binding.apply {
                tvListTitleMovie.text = movie.title
                tvListDurationMovie.text = movie.duration
                tvListGenreMovie.text = movie.genre

                Glide.with(itemView.context)
                    .load(movie.img)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_eror)
                    .into(imgListPosterMovie)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_ID, movie.movieId)
                    itemView.context.startActivity(intent)
                }
            }
        }

    }

}
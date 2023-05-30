package com.codico.movieandtravelapp.viewholders

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codico.movieandtravelapp.R
import com.codico.movieandtravelapp.data.vos.MovieVO
import com.codico.movieandtravelapp.delegates.MovieDelegate
import com.codico.movieandtravelapp.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.view_holder_upcomming_movie_item.view.*

class UpCommingMovieListViewHolder(itemView: View, mDelegate: MovieDelegate) :
    RecyclerView.ViewHolder(itemView) {

    private var movie: MovieVO? = null

    init {
        itemView.ivMovieImageUpComming.setOnClickListener {
            movie?.let {
                mDelegate.onTapMovie(it)
            }

        }

        itemView.ivLoveUpComming.setOnClickListener {
            movie?.let {
                mDelegate.onLoveMovie(it)
            }
        }
    }

    fun bindData(movieVO: MovieVO) {

        movie = movieVO
        movie?.let {
            Glide.with(itemView.context)
                .load("$IMAGE_BASE_URL${it.posterPath}")
                .into(itemView.ivMovieImageUpComming)

            itemView.tvMovieNameUpComming.text = it.title
            itemView.tvMovieDesc.text = it.overview
            itemView.tvLoveCountInUpComming.text = it.voteAverage.toString()

            if(it.isFavourite){
                itemView.ivLoveUpComming.setColorFilter(ContextCompat.getColor(itemView.context,
                    R.color.red), android.graphics.PorterDuff.Mode.MULTIPLY)
            }else{
                itemView.ivLoveUpComming.setColorFilter(
                    ContextCompat.getColor(itemView.context,
                        R.color.colorSecondaryText), android.graphics.PorterDuff.Mode.MULTIPLY)
            }

        }

    }
}
package com.codico.movieandtravelapp.viewholders

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codico.movieandtravelapp.R
import com.codico.movieandtravelapp.data.vos.MovieVO
import com.codico.movieandtravelapp.delegates.MovieDelegate
import com.codico.movieandtravelapp.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.view_holder_movie_item.view.*


class MovieViewHolder(itemView: View, mDelegate: MovieDelegate) :
    RecyclerView.ViewHolder(itemView) {

    private var movie: MovieVO? = null

    init {
        itemView.ivMovieImage.setOnClickListener {
            movie?.let {
                mDelegate.onTapMovie(it)
            }

        }

        itemView.ivLove.setOnClickListener {
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
                .into(itemView.ivMovieImage)

            itemView.tvMovieName.text = it.title

            if(it.isFavourite){
                itemView.ivLove.setColorFilter(
                    ContextCompat.getColor(itemView.context,
                        R.color.red), android.graphics.PorterDuff.Mode.MULTIPLY)
            }else{
                itemView.ivLove.setColorFilter(
                    ContextCompat.getColor(itemView.context,
                        R.color.colorSecondaryText), android.graphics.PorterDuff.Mode.MULTIPLY)
            }

        }



    }
}

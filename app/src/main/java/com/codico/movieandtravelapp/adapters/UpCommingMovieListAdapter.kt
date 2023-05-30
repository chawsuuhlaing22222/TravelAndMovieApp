package com.codico.movieandtravelapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codico.movieandtravelapp.R
import com.codico.movieandtravelapp.data.vos.MovieVO
import com.codico.movieandtravelapp.delegates.MovieDelegate
import com.codico.movieandtravelapp.viewholders.UpCommingMovieListViewHolder


class UpCommingMovieListAdapter(private val mDelegate: MovieDelegate) : RecyclerView.Adapter<UpCommingMovieListViewHolder>(){
    private var mUpCommingMovieList:List<MovieVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpCommingMovieListViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_upcomming_movie_item,parent,false)
        return UpCommingMovieListViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: UpCommingMovieListViewHolder, position: Int) {

        if(mUpCommingMovieList.isNotEmpty()){
            holder.bindData(mUpCommingMovieList[position])
        }
    }

    override fun getItemCount(): Int {
        return mUpCommingMovieList.size ?: 0
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(movieList:List<MovieVO>){
        mUpCommingMovieList=movieList
        notifyDataSetChanged()
    }
}
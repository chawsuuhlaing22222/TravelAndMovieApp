package com.codico.movieandtravelapp.activities

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codico.movieandtravelapp.R
import com.codico.movieandtravelapp.adapters.BestActorAdapter
import com.codico.movieandtravelapp.data.vos.ActorVO
import com.codico.movieandtravelapp.data.vos.MovieVO
import com.codico.movieandtravelapp.mvp.presenters.MovieDetailPresenterImpl
import com.codico.movieandtravelapp.mvp.views.MovieDetailView
import com.codico.movieandtravelapp.utils.IMAGE_BASE_URL
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity(),MovieDetailView {

    var mMovie:MovieVO?=null
    lateinit var mPresenter:MovieDetailPresenterImpl
    lateinit var mActorAdapter:BestActorAdapter

    companion object{
        const val IEXTRA_MOVIE_ID="movieid"
        fun newIntent(context: Context,movieId: Int):Intent{
            var intent=Intent(context,MovieDetailActivity::class.java)
            intent.putExtra(IEXTRA_MOVIE_ID,movieId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movieId=intent.getIntExtra(IEXTRA_MOVIE_ID,0)
        setUpPresenter()
        setUpRecycler()
        setUpListener()
        mPresenter.onUiReadyInMovieDetail(this,movieId)
    }

    private fun setUpListener() {
        ivLoveDetail.setOnClickListener {
            mMovie?.let { it1 -> mPresenter.onLoveMovie(it1) }
        }

        ivBack.setOnClickListener {
            finish()
        }
    }

    private fun setUpRecycler() {
        mActorAdapter = BestActorAdapter()
        rvCasts.apply {
            adapter=mActorAdapter
            layoutManager=LinearLayoutManager(this@MovieDetailActivity,LinearLayoutManager.HORIZONTAL,false)
            addItemDecoration(object :RecyclerView.ItemDecoration(){
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    super.getItemOffsets(outRect, view, parent, state)
                    outRect.left =20
                }
            })
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[MovieDetailPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    override fun showMovieDetail(movie: MovieVO) {
        mMovie=movie
        Glide.with(this)
            .load("$IMAGE_BASE_URL${movie.backDropPath}")
            .into(ivMovieCoverInDetail)

       tvMovieTitleDetail.text = movie.title
        tvMovieOverview.text = movie.overview
        if(movie.isFavourite){
           ivLoveDetail.setColorFilter(
                ContextCompat.getColor(this,
                    R.color.red), android.graphics.PorterDuff.Mode.MULTIPLY)
        }else{
            ivLoveDetail.setColorFilter(
                ContextCompat.getColor(this,
                    R.color.colorSecondaryText), android.graphics.PorterDuff.Mode.MULTIPLY)
        }
    }

    override fun showCreditsByMovie(casts: List<ActorVO>) {
       mActorAdapter.setNewData(casts)
    }

    override fun navigateBack() {
       finish()
    }

    override fun showErrorMsg(errorMsg: String) {
        Snackbar.make(window.decorView,errorMsg, Snackbar.LENGTH_SHORT).show()
    }
}
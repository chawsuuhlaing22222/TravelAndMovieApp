package com.codico.movieandtravelapp.fragments

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codico.movieandtravelapp.R
import com.codico.movieandtravelapp.activities.MovieDetailActivity
import com.codico.movieandtravelapp.adapters.MovieAdapter
import com.codico.movieandtravelapp.adapters.UpCommingMovieListAdapter
import com.codico.movieandtravelapp.data.vos.MovieVO
import com.codico.movieandtravelapp.mvp.presenters.MovieListPresenter
import com.codico.movieandtravelapp.mvp.presenters.MovieListPresenterImpl
import com.codico.movieandtravelapp.mvp.views.MovieListView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_movies.*


class MoviesFragment : Fragment(),MovieListView {

lateinit var mPresenter:MovieListPresenter
lateinit var mUpcommingMovieAdapter:UpCommingMovieListAdapter
lateinit var mPopularMovieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpRecycler()
        mPresenter.onUiReady(this)

    }

    private fun setUpRecycler() {
        mPopularMovieAdapter= MovieAdapter(mPresenter)
        rvPopularMovies.apply {
            adapter=mPopularMovieAdapter
            layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    super.getItemOffsets(outRect, view, parent, state)
                    outRect.left=20
                }
            })
        }

        mUpcommingMovieAdapter=UpCommingMovieListAdapter(mPresenter)
        rvUpcommingMovies.apply {
                adapter=mUpcommingMovieAdapter
                layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
                addItemDecoration(object : RecyclerView.ItemDecoration() {
                    override fun getItemOffsets(
                        outRect: Rect,
                        view: View,
                        parent: RecyclerView,
                        state: RecyclerView.State
                    ) {
                        super.getItemOffsets(outRect, view, parent, state)
                        outRect.top=20
                    }
                })
            }


    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProvider(this)[MovieListPresenterImpl::class.java]
        mPresenter.initView(this)
    }

    override fun showNowPlayingMovies(nowPlayingMovieList: List<MovieVO>) {

    }

    override fun showPopularMovies(popularMovieList: List<MovieVO>) {
        mPopularMovieAdapter.setNewData(popularMovieList)
    }

    override fun showUpCommingMovies(upcommingMovieList: List<MovieVO>) {
      mUpcommingMovieAdapter.setNewData(upcommingMovieList)
    }

    override fun navigateToMovieDetailScrn(movieId: Int) {
        startActivity(context?.let { MovieDetailActivity.newIntent(it,movieId) })
    }

    override fun showErrorMsg(errorMsg: String) {
        activity?.window?.decorView?.let { Snackbar.make(it,errorMsg,Snackbar.LENGTH_SHORT).show() }
    }


}
package com.codico.movieandtravelapp.mvp.presenters

import com.codico.movieandtravelapp.delegates.MovieDelegate
import com.codico.movieandtravelapp.mvp.views.MovieListView

//inheritance delegate to solve view holder action
//inheritance basepresenter to show initial data
interface MovieListPresenter : IBasePresenter, MovieDelegate{
    //set view reference
        fun initView(view: MovieListView)

}
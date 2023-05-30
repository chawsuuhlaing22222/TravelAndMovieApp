package com.codico.movieandtravelapp.adapters


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.codico.movieandtravelapp.fragments.EmptyFragment
import com.codico.movieandtravelapp.fragments.MoviesFragment


class HomeVPAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> {
              /*  if(!bookListData.isNullOrEmpty()){
                    //pass data
                    var bundle = Bundle().apply {
                        this.putString(BOOK_LIST_PARAM, Gson().toJson(bookListData))
                    }
                    ebookFragment.arguments = bundle
                }*/

                MoviesFragment()
            }

            1 -> {

                EmptyFragment()
            }
            else -> {

                EmptyFragment()
            }
        }
    }
}
package com.codico.movieandtravelapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codico.movieandtravelapp.R
import com.codico.movieandtravelapp.data.vos.ActorVO
import com.codico.movieandtravelapp.viewholders.BestActorViewHolder

class BestActorAdapter: RecyclerView.Adapter<BestActorViewHolder>() {

    private var actorList:List<ActorVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestActorViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.view_holder_best_actor_item,parent,false)
        return BestActorViewHolder(view)
    }

    override fun onBindViewHolder(holder: BestActorViewHolder, position: Int) {
        if(actorList.isNotEmpty()){
            holder.bindData(actorList.get(position))
        }
    }

    override fun getItemCount(): Int {
        return actorList.count()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(actors: List<ActorVO>) {
        actorList=actors
        notifyDataSetChanged()
    }
}
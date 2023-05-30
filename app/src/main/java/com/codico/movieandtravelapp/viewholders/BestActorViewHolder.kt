package com.codico.movieandtravelapp.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codico.movieandtravelapp.data.vos.ActorVO
import com.codico.movieandtravelapp.utils.IMAGE_BASE_URL
import kotlinx.android.synthetic.main.view_holder_best_actor_item.view.*

class BestActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindData(actor: ActorVO) {

        Glide.with(itemView.context)
            .load("$IMAGE_BASE_URL${actor.profile_path}")
            .into(itemView.ivActorImage)

        itemView.tvActorName.text=actor.name
    }
}
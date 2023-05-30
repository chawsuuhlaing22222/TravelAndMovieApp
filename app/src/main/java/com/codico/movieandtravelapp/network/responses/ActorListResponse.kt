package com.codico.movieandtravelapp.network.responses

import com.codico.movieandtravelapp.data.vos.ActorVO
import com.google.gson.annotations.SerializedName


data class ActorListResponse (
    @SerializedName("results")
    val results:List<ActorVO>?
        )
package com.codico.movieandtravelapp.network.responses

import com.google.gson.annotations.SerializedName
import com.codico.movieandtravelapp.data.vos.ActorVO

data class MovieCreditResponse(

    @SerializedName("cast")
    val cast: List<ActorVO>?,

    @SerializedName("crew")
    val crew: List<ActorVO>?
)

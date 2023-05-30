package com.codico.movieandtravelapp.network.responses

import com.codico.movieandtravelapp.data.vos.DateVO
import com.codico.movieandtravelapp.data.vos.MovieVO
import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("dates")
    val dates: DateVO?,

    @SerializedName("page")
    val page: Int?,

    @SerializedName("results")
    val results: List<MovieVO>?
)

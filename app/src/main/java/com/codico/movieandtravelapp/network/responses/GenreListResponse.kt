package com.codico.movieandtravelapp.network.responses

import com.codico.movieandtravelapp.data.vos.GenreVO
import com.google.gson.annotations.SerializedName

data class GenreListResponse (
@SerializedName("genres")
val genres: List<GenreVO>?
)
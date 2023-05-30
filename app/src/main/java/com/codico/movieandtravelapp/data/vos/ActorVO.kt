package com.codico.movieandtravelapp.data.vos

import com.google.gson.annotations.SerializedName

data class ActorVO(
    @SerializedName("adult")
    val adult: Boolean?,

    @SerializedName("gender")
    val gender: Int?,

    @SerializedName("id")
    val id: Int?,

    @SerializedName("known_for")
    val knownFor: List<MovieVO>?,

    @SerializedName("known_for_department")
    val knownForDepartment: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("popularity")
    val popularity: Double?,

    @SerializedName("profile_path")
    val profile_path: String?,

    @SerializedName("original_name")
    val originalName: String?,

    @SerializedName("cast_id")
    val cast_id: Int?,

    @SerializedName("character")
    val character: String?,

    @SerializedName("credit_id")
    val creditId: String?,

    @SerializedName("order")
    val order: Int?,

    @SerializedName("department")
    val department: String?,

    @SerializedName("job")
    val job: String?
)
package com.codico.movieandtravelapp.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

import com.codico.movieandtravelapp.persistence.typeconverters.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
@TypeConverters(
    CollectionTypeConverter::class,
    GenreIdIdListTypeConverter::class,
    GenreListTypeConverter::class,
    ProductionCompanyListConverter::class,
    ProductionCountryListConverter::class,
    SpokenLanguageListConverter::class
)
data class MovieVO(

    @SerializedName("adult")
    @ColumnInfo(name = "adult")
    val adult:Boolean?,

    @SerializedName("backdrop_path")
    @ColumnInfo(name = "backdrop_path")
    val backDropPath:String?,

    @SerializedName("genre_ids")
    @ColumnInfo(name = "genre_ids")
    val genreIds:List<Int>?,

    @SerializedName("id")
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id:Int?,

    @SerializedName("original_language")
    @ColumnInfo(name = "original_language")
    val originalLanguage:String?,

    @SerializedName("original_title")
    @ColumnInfo(name = "original_title")
    val originalTtitle:String?,

    @SerializedName("overview")
    @ColumnInfo(name = "overview")
    val overview:String?,

    @SerializedName("popularity")
    @ColumnInfo(name = "popularity")
    val popularity:Double?,

    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_path")
    val posterPath:String?,

    @SerializedName("release_date")
    @ColumnInfo(name = "release_date")
    val releaseDate:String?,

    @SerializedName("title")
    @ColumnInfo(name = "title")
    val title:String?,

    @SerializedName("video")
    @ColumnInfo(name = "video")
    val video:Boolean?,

    @SerializedName("vote_average")
    @ColumnInfo(name = "vote_average")
    val voteAverage:Double?,

    @SerializedName("vote_count")
    @ColumnInfo(name = "vote_count")
    val voteCount:Int?,

    @SerializedName("belongs_to_collection")
    @ColumnInfo(name = "belongs_to_collection")
    val belongsToCollection: CollectionVO?,

    @SerializedName("budget")
    @ColumnInfo(name = "budget")
    val budget:Long?,

    @SerializedName("genres")
    @ColumnInfo(name = "genres")
    val genres:List<GenreVO>?,

    @SerializedName("homepage")
    @ColumnInfo(name = "homepage")
    val homepage:String?,

    @SerializedName("imdb_id")
    @ColumnInfo(name = "imdb_id")
    val imdb_id:String?,

    @SerializedName("production_companies")
    @ColumnInfo(name = "production_companies")
    val productionPompanies:List<ProductionCompanyVO>?,

    @SerializedName("production_countries")
    @ColumnInfo(name = "production_countries")
    val productionCountries:List<ProductionCountryVO>?,

    @SerializedName("revenue")
    @ColumnInfo(name = "revenue")
    val revenue:Int?,

    @SerializedName("runtime")
    @ColumnInfo(name = "runtime")
    val runtime:Int?,

    @SerializedName("spoken_languages")
    @ColumnInfo(name = "spoken_languages")
    val spokenLanguages:List<LanguageVO>?,

    @SerializedName("status")
    @ColumnInfo(name = "status")
    val status:String?,

    @SerializedName("tagline")
    @ColumnInfo(name = "tagline")
    val tagline:String?,

    @ColumnInfo(name = "type")
    var type:String?,

    @ColumnInfo(name = "favourite")
    var isFavourite:Boolean=false,

    )
const val NOW_PLAYING="NOW_PLAYING"
const val UPCOMMING="UPCOMING"
const val POPULAR="POPULAR"
const val TOP_RATED="TOP_RATED"

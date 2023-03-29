package com.codepath.ActorGuide

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class SearchActor(
    @SerialName("results")
    val results: List<Actor>?
)
@Keep
@Serializable
data class Actor(
    @SerialName("poster_path")
    val image: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("overview")
    val overview: String?,
    @SerialName("vote_count")
    val voteCount: Int?,
    @SerialName("first_air_date")
    val firstAir: String?,

) : java.io.Serializable {
    val mediaImageUrl = "https://image.tmdb.org/t/p/w500${image}"
}
//@Keep
//@Serializable
//data class OneOf(
  //  @SerialName("overview")
    //val title: String?)
    //@SerialName("release_date")
    //val releaseDate: String?,
  //  @SerialName("overview")
  //  val overview: String?
  // @SerialName("media_type")
  //  val mediatype: String
//) : java.io.Serializable

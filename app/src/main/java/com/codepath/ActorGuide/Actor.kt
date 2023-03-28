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
    @SerialName("profile_path")
    val image: String?,
    @SerialName("adult")
    val adult: Boolean?,
    @SerialName("known_for")
    val known: List<OneOf>?,

) : java.io.Serializable {
    val mediaImageUrl = "https://api.themoviedb.org/3/person/popular${known?.firstOrNull { it.title != null }?.title ?: ""}"
}

@Keep
@kotlinx.serialization.Serializable
data class OneOf(
    @SerialName("title")
    val title: String?,
    @SerialName("release_date")
    val releaseDate: String?,
    @SerialName("overview")
    val overview: String?
)

@androidx.annotation.Keep
@Serializable
data class Known(
    @SerialName("url")
    val url: String?
) : java.io.Serializable
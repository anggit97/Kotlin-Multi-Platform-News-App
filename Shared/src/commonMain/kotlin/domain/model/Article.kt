package domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Optional

@Serializable
data class Article(
    @Optional
    @SerialName("author")
    val author: String?,
    @Optional
    @SerialName("content")
    val content: String?,
    @Optional
    @SerialName("description")
    val description: String?,
    @Optional
    @SerialName("publishedAt")
    val publishedAt: String?,
    @Optional
    @SerialName("source")
    val source: Source?,
    @Optional
    @SerialName("title")
    val title: String?,
    @Optional
    @SerialName("url")
    val url: String?,
    @Optional
    @SerialName("urlToImage")
    val urlToImage: String?
)
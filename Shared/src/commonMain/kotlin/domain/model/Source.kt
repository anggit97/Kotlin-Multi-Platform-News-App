package domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Optional

@Serializable
data class Source(
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?
)
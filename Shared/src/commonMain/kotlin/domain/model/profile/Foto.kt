package domain.model.profile


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Optional

@Serializable
data class Foto(
    @SerialName("original")
    val original: String?,
    @SerialName("thumb")
    val thumb: String?
)
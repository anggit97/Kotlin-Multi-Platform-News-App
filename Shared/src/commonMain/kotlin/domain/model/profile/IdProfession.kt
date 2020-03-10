package domain.model.profile


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Optional

@Serializable
data class IdProfession(
    @SerialName("id")
    val id: Int?,
    @SerialName("nama_profesi")
    val namaProfesi: String?
)
package domain.model.profile


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Optional

@Serializable
data class UserDetail(
    @SerialName("biodata")
    val biodata: String?,
    @SerialName("jenis_kelamin")
    val jenisKelamin: String?,
    @SerialName("tanggal_lahir")
    val tanggalLahir: String?,
    @SerialName("website")
    val website: String?
)
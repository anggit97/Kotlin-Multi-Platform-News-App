package domain.model.profile


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserProfileResponse(
    @SerialName("email")
    val email: String?,
    @SerialName("foto")
    val foto: Foto?,
    @SerialName("id")
    val id: Int?,
    @SerialName("id_profession")
    val idProfession: IdProfession?,
    @SerialName("jenis_sekolah")
    val jenisSekolah: String?,
    @SerialName("member_card")
    val memberCard: String?,
    @SerialName("nama")
    val nama: String?,
    @SerialName("nomor_induk")
    val nomorInduk: String?,
    @SerialName("status_aktif")
    val statusAktif: String?,
    @SerialName("telepon")
    val telepon: String?,
    @SerialName("universitas")
    val universitas: String?,
    @SerialName("user_detail")
    val userDetail: UserDetail?
)
data class UserModel(
    val users: List<Users>
)

data class Users(
    val active: Int,
    val cpf: String,
    val email: String,
    val id: Int,
    val name: String,
    val surname: String
)
import com.example.veraxapplication.modele.user.User


interface IUsersDataManager {
    val allUsers: List<Any?>?

    fun getUser(pseudo : String): User?
    fun getUsers(): List<User>
}
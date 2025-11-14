import com.feshur1007.tallerapp.data.model.User
import com.feshur1007.tallerapp.data.remote.RetrofitInstance

class AuthRepository {
    suspend fun login(user: User): Result<String> {
        val response = RetrofitInstance.api.login(user)
        return if (response.isSuccessful) {
            val token = response.body()?.token
            if (!token.isNullOrEmpty()) Result.success(token)
            else Result.failure(Exception("Token vacío"))
        } else {
            Result.failure(Exception("Login fallido"))
        }
    }
}
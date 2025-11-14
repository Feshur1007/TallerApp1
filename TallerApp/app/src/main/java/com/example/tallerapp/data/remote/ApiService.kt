import retrofit2.http.*
import retrofit2.Response
import com.feshur1007.tallerapp.data.model.*

interface ApiService {

    @POST("auth/login")
    suspend fun login(@Body user: User): Response<AuthResponse>

    @GET("products")
    suspend fun getProducts(): List<Product>
}

data class AuthResponse(val token: String)
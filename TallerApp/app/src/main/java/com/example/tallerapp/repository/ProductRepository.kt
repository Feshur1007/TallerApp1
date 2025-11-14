import com.feshur1007.tallerapp.data.model.Product
import com.feshur1007.tallerapp.data.remote.RetrofitInstance

class ProductRepository {
    suspend fun getProducts(): List<Product> {
        return RetrofitInstance.api.getProducts()
    }
}
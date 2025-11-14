import com.feshur1007.tallerapp.data.local.CartDao
import com.feshur1007.tallerapp.data.local.CartEntity
import kotlinx.coroutines.flow.Flow

class CartRepository(private val dao: CartDao) {
    fun getAll(): Flow<List<CartEntity>> = dao.getAll()
    suspend fun insert(item: CartEntity) = dao.insert(item)
    suspend fun update(item: CartEntity) = dao.update(item)
    suspend fun delete(item: CartEntity) = dao.delete(item)
    suspend fun clearAll() = dao.clearAll()
}
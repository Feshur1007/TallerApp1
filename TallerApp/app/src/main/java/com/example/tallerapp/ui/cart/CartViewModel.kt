import androidx.lifecycle.*
import com.feshur1007.tallerapp.repository.CartRepository
import com.feshur1007.tallerapp.data.local.CartEntity
import kotlinx.coroutines.launch

class CartViewModel(
    private val repository: CartRepository
) : ViewModel() {
    val cartItems: LiveData<List<CartEntity>> = repository.getAll().asLiveData()

    fun updateQuantity(item: CartEntity, newQuantity: Int) {
        viewModelScope.launch {
            repository.update(item.copy(quantity = newQuantity))
        }
    }

    fun removeItem(item: CartEntity) {
        viewModelScope.launch { repository.delete(item) }
    }

    fun clearCart() {
        viewModelScope.launch { repository.clearAll() }
    }
}
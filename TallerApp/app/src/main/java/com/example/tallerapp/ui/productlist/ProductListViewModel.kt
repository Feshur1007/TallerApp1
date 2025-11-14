import androidx.lifecycle.*
import kotlinx.coroutines.launch
import com.feshur1007.tallerapp.repository.ProductRepository
import com.feshur1007.tallerapp.data.model.Product

class ProductListViewModel(
    private val repository: ProductRepository
) : ViewModel() {

    val products = MutableLiveData<List<Product>>()

    fun loadProducts() {
        viewModelScope.launch {
            val result = repository.getProducts()
            products.value = result
        }
    }
}
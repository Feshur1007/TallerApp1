import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.feshur1007.tallerapp.data.model.Product
import com.feshur1007.tallerapp.databinding.ItemProductBinding

class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.txtName.text = product.title
            binding.txtPrice.text = "$${product.price}"
            binding.txtDesc.text = product.description
            Glide.with(binding.imgProduct).load(product.image).into(binding.imgProduct)
            // Manejar cantidad, agregar al carrito (implementación requiere acceso a ViewModel o Listener)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount() = products.size
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) = holder.bind(products[position])
}
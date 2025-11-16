import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.feshur1007.tallerapp.data.local.CartEntity
import com.feshur1007.tallerapp.databinding.ItemCartBinding

class CartAdapter(
    private val items: List<CartEntity>,
    private val viewModel: CartViewModel
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(private val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CartEntity) {
            binding.txtName.text = item.productName
            binding.txtPrice.text = "$${item.price}"
            binding.txtQuantity.text = item.quantity.toString()
            Glide.with(binding.imgProduct).load(item.productImage).into(binding.imgProduct)
            binding.btnIncrease.setOnClickListener { viewModel.updateQuantity(item, item.quantity + 1) }
            binding.btnDecrease.setOnClickListener {
                if (item.quantity > 1) viewModel.updateQuantity(item, item.quantity - 1)
            }
            binding.btnRemove.setOnClickListener { viewModel.removeItem(item) }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder =
        CartViewHolder(ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun getItemCount() = items.size
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) = holder.bind(items[position])
}
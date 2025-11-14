import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.feshur1007.tallerapp.databinding.FragmentCartBinding
import com.feshur1007.tallerapp.ui.adapters.CartAdapter
import com.google.android.material.snackbar.Snackbar

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private val viewModel: CartViewModel by viewModels { /* Factory with CartRepository */ }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.cartItems.observe(viewLifecycleOwner) { items ->
            binding.recyclerCart.adapter = CartAdapter(items, viewModel)
            val total = items.sumOf { it.price * it.quantity }
            binding.txtTotal.text = "Total: $${"%.2f".format(total)}"
        }

        binding.btnBuy.setOnClickListener {
            viewModel.clearCart()
            Snackbar.make(binding.root, "¡Compra exitosa!", Snackbar.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_cartFragment_to_productListFragment)
        }

        binding.btnClear.setOnClickListener {
            viewModel.clearCart()
        }
    }
}
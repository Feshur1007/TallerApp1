import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.feshur1007.tallerapp.databinding.FragmentProductListBinding
import com.feshur1007.tallerapp.ui.adapters.ProductAdapter

class ProductListFragment : Fragment() {
    private lateinit var binding: FragmentProductListBinding
    private val viewModel: ProductListViewModel by viewModels { /* Factory with ProductRepository */ }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentProductListBinding.inflate(inflater, container, false)
        binding.btnCart.setOnClickListener {
            findNavController().navigate(R.id.action_productListFragment_to_cartFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.loadProducts()
        viewModel.products.observe(viewLifecycleOwner) { products ->
            binding.recyclerProducts.adapter = ProductAdapter(products)
        }
    }
}
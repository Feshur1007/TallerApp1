import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.feshur1007.tallerapp.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels { /* Factory with AuthRepository and SessionManager */ }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnLogin.setOnClickListener {
            val user = binding.inputUser.text.toString()
            val pass = binding.inputPass.text.toString()
            viewModel.login(user, pass)
        }

        viewModel.loginState.observe(viewLifecycleOwner) {
            if (it.isSuccess) {
                findNavController().navigate(R.id.action_loginFragment_to_productListFragment)
            } else {
                Snackbar.make(binding.root, "Login incorrecto", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}
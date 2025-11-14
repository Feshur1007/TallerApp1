import androidx.lifecycle.*
import kotlinx.coroutines.launch
import com.feshur1007.tallerapp.repository.AuthRepository
import com.feshur1007.tallerapp.data.local.SessionManager

class LoginViewModel(
    private val repository: AuthRepository,
    private val sessionManager: SessionManager
) : ViewModel() {

    val loginState = MutableLiveData<Result<Unit>>()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val result = repository.login(com.feshur1007.tallerapp.data.model.User(username, password))
            if (result.isSuccess) {
                sessionManager.saveSession(result.getOrNull()!!)
                loginState.value = Result.success(Unit)
            } else {
                loginState.value = Result.failure(result.exceptionOrNull()!!)
            }
        }
    }
}
import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "session_preferences")

class SessionManager(private val context: Context) {

    companion object {
        val LOGGED_IN = booleanPreferencesKey("logged_in")
        val AUTH_TOKEN = stringPreferencesKey("auth_token")
    }

    suspend fun saveSession(token: String) {
        context.dataStore.edit {
            it[LOGGED_IN] = true
            it[AUTH_TOKEN] = token
        }
    }

    suspend fun clearSession() {
        context.dataStore.edit {
            it.clear()
        }
    }

    val isLoggedIn: Flow<Boolean> = context.dataStore.data
        .map { prefs -> prefs[LOGGED_IN] ?: false }

    val authToken: Flow<String?> = context.dataStore.data
        .map { prefs -> prefs[AUTH_TOKEN] }
}
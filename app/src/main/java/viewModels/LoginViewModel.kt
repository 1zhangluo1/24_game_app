package viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel(){

    private val _username = mutableStateOf("")
    var username: State<String> = _username

    private val _password = mutableStateOf("")
    var password: State<String> = _password

    val isLoading = mutableStateOf(false)

    private val _loginSuccess = mutableStateOf(false)
    val loginSuccess: State<Boolean> = _loginSuccess

    fun onUsernameChanged(newUsername: String) {
        _username.value = newUsername
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    fun login() {
        isLoading.value = true
        viewModelScope.launch {
            delay(2000)
            isLoading.value = false
            _loginSuccess.value = username.value == "user" && password.value == "password"
        }
    }
}
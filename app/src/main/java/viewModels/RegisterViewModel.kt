package viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RegisterViewModel : ViewModel() {

    val isRegister = mutableStateOf(false)
    val registerAccount = mutableStateOf("")
    val registerPassword = mutableStateOf("")
    val registerConfirmPassword = mutableStateOf("")

}
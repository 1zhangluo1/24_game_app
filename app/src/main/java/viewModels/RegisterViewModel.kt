package viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import data.model.ValidMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    val isRegister = mutableStateOf(false)
    val registerAccount = mutableStateOf("")
    val registerPassword = mutableStateOf("")
    val registerConfirmPassword = mutableStateOf("")
    private val _validationPasswordEvent = MutableSharedFlow<ValidMessage>()
    val validationPasswordEvent = _validationPasswordEvent.asSharedFlow()

    fun validatePasswords() {
        CoroutineScope(Dispatchers.Main).launch {
            val result = when {
                registerAccount.value.isEmpty() -> {
                    ValidMessage.Error("账号不能为空")
                }
                registerPassword.value.isEmpty() || registerConfirmPassword.value.isEmpty() -> {
                    ValidMessage.Error("密码不能为空")
                }
                registerPassword.value != registerConfirmPassword.value -> {
                    ValidMessage.Error("两次密码不一致")
                }
                else -> {
                   ValidMessage.Success
                }
            }
            _validationPasswordEvent.emit(result)
        }
    }

}
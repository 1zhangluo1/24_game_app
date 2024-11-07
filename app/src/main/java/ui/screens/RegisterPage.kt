package ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import data.model.ValidMessage
import kotlinx.coroutines.flow.collectLatest
import ui.components.BackIcons
import viewModels.RegisterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPage( viewModel: RegisterViewModel = RegisterViewModel(), navController: NavController ) {

    val context = LocalContext.current
    val registerAccount = viewModel.registerAccount
    val registerPassword = viewModel.registerPassword
    val registerConfirmPassword = viewModel.registerConfirmPassword

    LaunchedEffect(viewModel.validationPasswordEvent) {
        viewModel.validationPasswordEvent.collectLatest { result ->
            when (result) {
                is ValidMessage.Success -> {
                    Toast.makeText(context, "验证成功", Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
                }
                is ValidMessage.Error -> {
                    Toast.makeText(context, result.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "注册") },
                navigationIcon = { BackIcons(naviController = navController) }
            )
        }
    ) {
        innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .padding(vertical = 20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                value = registerAccount.value ,
                onValueChange = { registerAccount.value = it },
                label = { Text(text = "账号")},
                shape = RoundedCornerShape(12.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = registerPassword.value,
                onValueChange = { registerPassword.value = it },
                label = { Text(text = "密码")},
                shape = RoundedCornerShape(12.dp),
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = registerConfirmPassword.value,
                onValueChange = { registerConfirmPassword.value = it },
                label = { Text(text = "再次输入密码")},
                shape = RoundedCornerShape(12.dp),
            )
            Spacer(modifier = Modifier.height(15.dp))
            ElevatedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.validatePasswords()
                },
                contentPadding = PaddingValues(vertical = 15.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    Color(0xFF4FB4F7),
                )
            ) {
                Text(text = "注册", fontSize = 18.sp, fontWeight = FontWeight.Bold, letterSpacing = 2.sp, color = Color.White)
            }
        }
    }

}
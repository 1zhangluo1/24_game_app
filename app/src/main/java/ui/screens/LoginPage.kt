package ui.screens

import android.content.res.Resources.Theme
import android.graphics.Paint.Align
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ui.components.BackIcons
import ui.components.LoadingDialog
import viewModels.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(viewModel: LoginViewModel = LoginViewModel(), navController: NavController) {

    val userName by viewModel.username
    val password by viewModel.password
    val isLoading by viewModel.isLoading
    val loginSuccess by viewModel.loginSuccess

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    BackIcons(naviController = navController)
                },
                title = {
                    Text("登录")
                }
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
            Box (modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = "24点游戏",
                    style = TextStyle(
                        fontSize = 35.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 4.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                value = userName,
                onValueChange = { viewModel.onUsernameChanged(it) },
                label = { Text(text = "账号")},
                shape = RoundedCornerShape(12.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = { viewModel.onPasswordChanged(it) },
                label = { Text(text = "密码")},
                shape = RoundedCornerShape(12.dp),
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextButton(
                modifier = Modifier.align(alignment = Alignment.End),
                onClick = { navController.navigate("register") }
            ) {
                Text(
                    text = "还没有账号？点击注册 →",
                    style = TextStyle(color =  Color(0xFF4FB4F7), fontSize = 14.sp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            ElevatedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { if (!viewModel.isLoading1.value) {
                    viewModel.isLoading1.value = true
                    GlobalScope.launch {
                        delay(2000)
                        viewModel.isLoading1.value = false
                    }
                } },
                contentPadding = PaddingValues(vertical = 15.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFF4FB4F7)
                )
            ) {
                Text(text = "登录",fontSize = 18.sp, fontWeight = FontWeight.Bold, letterSpacing = 2.sp)
            }
        }
    }
    LoadingDialog(text = "加载中...", isLoading = viewModel.isLoading1)
}

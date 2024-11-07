package ui.screens

import android.os.Build
import android.view.WindowInsetsController
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import ui.components.FlippingCard
import androidx.lifecycle.viewmodel.compose.viewModel
import ui.components.InputButton
import viewModels.GameViewModel

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun GamePage(viewModel: GameViewModel = viewModel(), navController: NavController) {

    val context = LocalContext.current
    
    val activity = LocalContext.current as ComponentActivity
    // 使用 effect 只在 composable 第一次启动时设置导航栏颜色
    LaunchedEffect(Unit) {
        activity.window.navigationBarColor = Color(0xFFAF5719).toArgb()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val decorView = activity.window.decorView
            val flags = decorView.systemUiVisibility
            flags or WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
        }
        delay(1000)
        viewModel.isFlipped.value = !viewModel.isFlipped.value
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(viewModel.gradientBrush),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val style = TextStyle(
                    fontSize = 22.sp,
                    color = Color(0xFFF5D5BF),
                    fontWeight = FontWeight.Bold
                )
                Text(text = "本轮数字:", style = style)
                Text(text = "倒计时: 8s", style = style)
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                viewModel.cardColorList.map {
                    FlippingCard(isFlipped = viewModel.isFlipped, color = it, number = "24")
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(70.dp)
                    .clipToBounds(),
                colors = TextFieldDefaults.outlinedTextFieldColors (
                    containerColor = Color(0xFF552909),
                    unfocusedBorderColor = Color(0xFF552909),
                    focusedBorderColor = Color(0xFF552909)
                ),
                value = viewModel.inputExpression.value,
                onValueChange = { viewModel.inputExpression.value = it },
                shape = RoundedCornerShape(12.dp),
                readOnly = true,
                maxLines = 1,
            )
            Spacer(modifier = Modifier.height(75.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                repeat(4) {
                    InputButton(value = "14", modifier = Modifier
                        .weight(1f)
                        .height(50.dp)) {
                        Toast.makeText(context,"14",Toast.LENGTH_SHORT).show()
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                viewModel.expressionSigns.map {
                    InputButton(value = it, modifier = Modifier
                        .weight(1f)
                        .height(50.dp)) {
                        Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                viewModel.thirdStrings.map {
                    InputButton(value = it, modifier = Modifier
                        .weight(1f)
                        .height(50.dp)) {
                        Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                InputButton(value = "格式检查", modifier = Modifier
                    .weight(1f)
                    .height(50.dp)) {
                    Toast.makeText(context,"格式检查",Toast.LENGTH_SHORT).show()
                }
                InputButton(value = "查看答案", modifier = Modifier
                    .weight(1f)
                    .height(50.dp)) {
                    Toast.makeText(context,"查看答案",Toast.LENGTH_SHORT).show()
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            InputButton(value = "确认提交", modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(60.dp)) {
                Toast.makeText(context,"确认提交",Toast.LENGTH_SHORT).show()
            }
        }
    }

}
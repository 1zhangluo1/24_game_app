package ui.screens

import android.os.Build
import android.view.Window
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ui.components.NumberCardBack
import ui.components.NumberCardFront
import ui.theme.Pink80
import ui.theme.Purple80
import ui.theme.SoftBlue
import ui.theme.WarmYellow
import viewModels.GameViewModel

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun GamePage(viewModel: GameViewModel = GameViewModel(), navController: NavController) {

    val activity = LocalContext.current as ComponentActivity
    // 使用 effect 只在 composable 第一次启动时设置导航栏颜色
    LaunchedEffect(viewModel.gradientBrush) {
        activity.window.navigationBarColor = Color(0xFFAF5719).toArgb()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val decorView = activity.window.decorView
            val flags = decorView.systemUiVisibility
            flags or WindowInsetsController.APPEARANCE_LIGHT_NAVIGATION_BARS
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(viewModel.gradientBrush),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                NumberCardFront(number = "5", color = Purple80)
                NumberCardFront(number = "7", color = SoftBlue)
//                NumberCardFront(number = "12", color = WarmYellow)
//                NumberCardFront(number = "14", color = Pink80)
                NumberCardBack()
                NumberCardBack()
            }
        }
    }

}
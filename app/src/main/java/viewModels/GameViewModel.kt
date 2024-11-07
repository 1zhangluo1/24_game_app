package viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import ui.theme.LightCyan
import ui.theme.MintGreen
import ui.theme.PeachPink
import ui.theme.Purple80
import ui.theme.SoftPurple
import ui.theme.WarmYellow

class GameViewModel: ViewModel() {

    val isFlipped = mutableStateOf(false)
    val inputExpression = mutableStateOf("")
    val expressionSigns: List<String> = listOf("+","-","*","/")
    val thirdStrings: List<String> = listOf("(",")","一键清空")
    val cardColorList: List<Color> = listOf(WarmYellow, MintGreen, SoftPurple, LightCyan)
    val gradientBrush = Brush.radialGradient(
        colors = listOf(
            Color(0xFFDF8919), // 浅咖啡色（中间）
            Color(0xFFAF5719)  // 深咖啡色（边缘）
        ),
        radius = 1000f // 控制渐变的半径大小，可根据需求调整
    )

}
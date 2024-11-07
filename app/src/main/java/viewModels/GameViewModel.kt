package viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import ui.theme.Purple80

class GameViewModel: ViewModel() {

    val inputExpression = mutableStateOf("")
    val cardColorList: List<Color> = listOf(Purple80,Color.Cyan,)
    val gradientBrush = Brush.radialGradient(
        colors = listOf(
            Color(0xFFDF8919), // 浅咖啡色（中间）
            Color(0xFFAF5719)  // 深咖啡色（边缘）
        ),
        radius = 1000f // 控制渐变的半径大小，可根据需求调整
    )

}
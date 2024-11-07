package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputButton(value: String, modifier: Modifier, inputValue: () -> Unit) {
    ElevatedButton(
        modifier = modifier,
        onClick = { inputValue() },
        shape = RoundedCornerShape(12.dp), // 圆角形状
        elevation = ButtonDefaults.elevatedButtonElevation(8.dp),
        colors = ButtonDefaults.elevatedButtonColors(
            Color(0xFF9E9E9E)
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Box (
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFBBB9B9), // 较亮的灰色
                            Color(0xFF616161) // 较暗的灰色
                        )
                    )
                )
                .fillMaxSize(),
            contentAlignment = Alignment.Center

        ) {
            Text(
                text = value,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}
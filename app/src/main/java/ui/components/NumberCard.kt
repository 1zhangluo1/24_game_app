package ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zhangluo.twentyfourgame.R
import ui.theme.Purple80


@Composable
fun FlippingCard( isFlipped: MutableState<Boolean> ) {
    val rotateY = remember { Animatable(0f) }
    LaunchedEffect(isFlipped.value) {
        val targetRotation = if (isFlipped.value) 180f else 0f
        rotateY.animateTo(
            targetValue = targetRotation,
            animationSpec = tween(durationMillis = 500)
        )
    }
    Box(
        modifier = Modifier
            .graphicsLayer {
                rotationY = rotateY.value
                cameraDistance = 12 * density // 调整摄像机距离以获得更好的3D效果
            }
            .clickable {
                isFlipped.value = !isFlipped.value
            }
            .clipToBounds()
    ) {
        if (rotateY.value <= 90 || rotateY.value >= 270) {
            NumberCardFront(number = "24", color = Purple80)
        } else {
            NumberCardBack()
        }
    }
}

@Composable
fun NumberCardFront(number: String, color: Color) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = color,
        ),
        modifier = Modifier.size(width = 70.dp, height = 120.dp)
    ) {
        Box ( Modifier.fillMaxSize() ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = number,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NumberCardBack() {
    Card(
        modifier = Modifier.size(width = 70.dp, height = 120.dp)
    ) {
        Box (
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.card_background),
                contentDescription = "Poker Card",
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NumberCardPreview(number: String = "24", color: Color = Color.LightGray) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = color,
        ),
        modifier = Modifier.size(width = 70.dp, height = 100.dp)
    ) {
        Box ( Modifier.fillMaxSize() ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = number,
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
            )
        }
    }
}
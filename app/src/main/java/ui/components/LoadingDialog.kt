package ui.components


import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun LoadingDialog (text: String,isLoading: MutableState<Boolean>) {
    if (isLoading.value) {
        Dialog(onDismissRequest = { }) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(150.dp)
                    .background(Color(0xAA2C2C2C), shape = RoundedCornerShape(12.dp))
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(text = text, fontSize = 18.sp, color = Color.White, letterSpacing = 1.sp)
                }
            }
        }
    }
}
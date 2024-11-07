package ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BackIcons(naviController: NavController) {
    IconButton(onClick = { naviController.popBackStack() }) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "返回"
        )
    }
}
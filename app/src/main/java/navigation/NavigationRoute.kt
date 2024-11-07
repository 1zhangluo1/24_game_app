package navigation
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ui.screens.GamePage
import ui.screens.LoginPage
import ui.screens.RegisterPage

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun AppNaviRoute(navController : NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") { LoginPage(navController = navController) }
        composable("register") { RegisterPage(navController = navController) }
        composable("game") { GamePage(navController = navController) }
        composable("rank") {  }
        composable("record") {  }
    }
}
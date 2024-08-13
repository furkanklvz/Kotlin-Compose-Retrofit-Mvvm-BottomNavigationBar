package com.klavs.bottomnavigationbar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.klavs.bottomnavigationbar.model.BottomNavigationItemModel
import com.klavs.bottomnavigationbar.model.screen.Screen
import com.klavs.bottomnavigationbar.page.AnaEkran
import com.klavs.bottomnavigationbar.page.KesfetEkran
import com.klavs.bottomnavigationbar.page.ProfilEkran
import com.klavs.bottomnavigationbar.ui.theme.BottomNavigationBarTheme
import com.klavs.bottomnavigationbar.viewmodel.AnaEkranViewModel

class MainActivity : ComponentActivity() {
    val anaEkranViewModel: AnaEkranViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            BottomNavigationBarTheme {
                Greeting(anaEkranViewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Greeting(anaEkranViewModel: AnaEkranViewModel) {
    println("Greeting oluştu")
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val navItems = listOf(
        Screen.HomeScreen,
        Screen.SearchScreen,
        Screen.ProfileScreen
    )



    Scaffold(topBar = { TopAppBar(title = { Text(text = "bottom nav bar app") }) }, bottomBar = {
        NavigationBar {

            navItems.forEach { screen ->
                BottomNavigationItem(
                    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                    onClick = {
                        navController.navigate(screen.route) {
                            println(screen.title + "tıklandı")
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }

                    },
                    icon = {
                        if (currentDestination?.hierarchy?.any { it.route == screen.route } == true){
                            Icon(imageVector = screen.selectedIcon, contentDescription = screen.title)
                        }else{
                            Icon(imageVector = screen.unselectedIcon, contentDescription = screen.title)
                        }
                    },
                    label = { Text(text = screen.title) })
            }
        }
    }) {
        if (anaEkranViewModel.isLoading) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }

        }
        NavHost(navController = navController, startDestination = Screen.HomeScreen.route, modifier = Modifier.padding(it)) {
            composable(Screen.HomeScreen.route) {
                AnaEkran(anaEkranViewModel)
            }
            composable(Screen.ProfileScreen.route) {
                ProfilEkran()
            }
            composable(Screen.SearchScreen.route) {
                KesfetEkran()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}

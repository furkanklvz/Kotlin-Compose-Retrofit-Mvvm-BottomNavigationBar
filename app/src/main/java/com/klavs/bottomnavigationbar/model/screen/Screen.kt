package com.klavs.bottomnavigationbar.model.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val selectedIcon: ImageVector, val unselectedIcon: ImageVector) {
    object HomeScreen : Screen("home", "Ana Ekran", Icons.Filled.Home, Icons.Outlined.Home)
    object SearchScreen : Screen("search", "Keşfet", Icons.Filled.Search, Icons.Outlined.Search)
    object ProfileScreen : Screen("profile", "Profil", Icons.Filled.Person, Icons.Outlined.Person)

}
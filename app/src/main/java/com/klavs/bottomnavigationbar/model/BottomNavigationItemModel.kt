package com.klavs.bottomnavigationbar.model

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItemModel(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

package com.klavs.bottomnavigationbar.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.klavs.bottomnavigationbar.Greeting
import com.klavs.bottomnavigationbar.ui.theme.BottomNavigationBarTheme

@Composable
fun ProfilEkran() {
    println("Profil Ekran oluştu")
    BottomNavigationBarTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Profil", fontSize = 26.sp)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun Greeting3Preview() {
    ProfilEkran()
}
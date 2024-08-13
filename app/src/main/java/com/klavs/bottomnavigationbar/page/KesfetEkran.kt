package com.klavs.bottomnavigationbar.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.klavs.bottomnavigationbar.ui.theme.BottomNavigationBarTheme

@Composable
fun KesfetEkran() {
    println("Keşfet Ekran oluştu")
    BottomNavigationBarTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SearchField()
        }

    }
}

@Composable
fun SearchField() {
    var input by remember {
        mutableStateOf("")
    }
    TextField(
        shape = MaterialTheme.shapes.extraLarge,
        value = input,
        onValueChange = { input = it },
        placeholder = { Text(text = "Ara") },

        modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(16.dp)
    )


}

@Preview(showBackground = true)
@Composable
fun Greeting2Preview() {
    SearchField()
}
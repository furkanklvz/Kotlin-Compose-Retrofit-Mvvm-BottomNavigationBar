package com.klavs.bottomnavigationbar.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.klavs.bottomnavigationbar.Greeting
import com.klavs.bottomnavigationbar.MainActivity
import com.klavs.bottomnavigationbar.ui.theme.BottomNavigationBarTheme
import com.klavs.bottomnavigationbar.viewmodel.AnaEkranViewModel
import kotlinx.coroutines.CoroutineScope
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun AnaEkran(viewModel: AnaEkranViewModel) {
    println("Ana Ekran oluştu")
    val kriptolar by remember {
        mutableStateOf(viewModel.kriptolar)
    }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            items(kriptolar.value) {
                KriptoListRow(price = it.price, currency = it.currency)
                Spacer(modifier = Modifier.padding(3.dp))
            }
        }
    }

}


@Composable
fun KriptoListRow(price: String, currency: String) {
    println("KriptoListRow oluştu")
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally ,modifier = Modifier
            .fillMaxWidth(0.9f)
            .background(Color.LightGray, ShapeDefaults.Medium)
            .padding(10.dp)) {
            Text(
                text = currency,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(6.dp)
            )
            Text(
                text = price,
                fontSize = 28.sp,
                modifier = Modifier.padding(6.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun show() {
    KriptoListRow("BTC", "60216")
}

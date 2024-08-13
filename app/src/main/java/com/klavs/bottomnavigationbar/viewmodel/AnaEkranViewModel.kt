package com.klavs.bottomnavigationbar.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.klavs.bottomnavigationbar.model.ListedKriptoModel
import com.klavs.bottomnavigationbar.service.KriptoAPI
import com.klavs.bottomnavigationbar.service.KriptoAPIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AnaEkranViewModel : ViewModel() {

    private val apiService = KriptoAPIService.api
    val kriptolar = mutableStateOf<List<ListedKriptoModel>>(listOf())
    var isLoading by mutableStateOf(false)

    init {
        KriptolariAl()
    }

    fun KriptolariAl() {
        isLoading = true
        println("KriptolariAl fonksiyonu çalıştı")
        viewModelScope.launch(Dispatchers.IO) {

            val response = apiService.GetCyrptoList()
            withContext(Dispatchers.Main) {
                isLoading = false
                if (!response.isNullOrEmpty()){
                    println("veriler alındı")
                    kriptolar.value = response
                }
            }
        }
    }
}
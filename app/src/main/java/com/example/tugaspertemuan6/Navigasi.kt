package com.example.tugaspertemuan6

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tugaspertemuan6.view.FormList
import com.example.tugaspertemuan6.view.FormPendaftaran
import com.example.tugaspertemuan6.view.FormWelcome

enum class Navigasi{
    Home,
    List,
    Form
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
}
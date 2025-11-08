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
){
    Scaffold { isiRuang->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Home.name,

            modifier = Modifier
                .padding(isiRuang)
                .fillMaxSize()
        ){
            composable(route = Navigasi.Home.name){
                FormWelcome(
                    onMasukClick = {
                        navController.navigate(Navigasi.List.name)
                    }
                )
            }
            composable(route = Navigasi.List.name){
                FormList(
                    OnBackBtnClick = {
                        cancelAndBackToHome(navController)
                    },
                    OnNextBtnClick = {
                        navController.navigate(Navigasi.Form.name)
                    }
                )
            }
            composable(route = Navigasi.Form.name){
                FormPendaftaran(
                    OnKembaliBtnClick = {
                        navController.navigate(Navigasi.List.name)
                    },
                    OnSubmitBtnClick = {
                        submitAndGoToPopUp(navController)
                    }
                )
            }
        }
    }
}

private fun submitAndGoToPopUp(navController: NavHostController) {
    navController.navigate(Navigasi.Form.name)
}


private fun cancelAndBackToHome(
    navController: NavController
){
    navController.popBackStack(Navigasi.Home.name, inclusive = false)
}
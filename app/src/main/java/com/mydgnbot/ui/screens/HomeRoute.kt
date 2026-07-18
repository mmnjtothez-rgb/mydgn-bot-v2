package com.mydgnbot.ui.screens


import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.mydgnbot.ui.viewmodel.HomeViewModel



@Composable
fun HomeRoute(

    viewModel: HomeViewModel =
        hiltViewModel()

) {


    HomeScreen(

        viewModel = viewModel

    )


}

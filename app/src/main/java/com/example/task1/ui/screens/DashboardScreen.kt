package com.example.task1.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen

class DashboardScreen : Screen {
    @Composable
    override fun Content() {

    }


    @Composable
    private fun DashboardScreenContent(){
        Scaffold { innerPadding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(innerPadding)
            ) {
                Text("halo")
            }
        }
    }







    @Preview
    @Composable
    fun DashboardScreenContentPreview(){
        DashboardScreenContent()
    }

}
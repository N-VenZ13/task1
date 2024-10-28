package com.example.task1.ui.screens

import Dashboard
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.task1.R

class DashboardScreen : Screen {
    @Composable
    override fun Content() {

    }


    @Composable
    private fun DashboardScreenContent(){
        Scaffold { innerPadding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(innerPadding).background(color = Color(0xFFFFFDE1)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.padding(20.dp))
                Text("Selamat Datang User", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.W600, fontFamily = FontFamily.Monospace))
                Spacer(modifier = Modifier.padding(8.dp))

                Image(painter = painterResource(R.drawable.logo), contentDescription = "logo", modifier = Modifier.size(width = 240.dp, height = 80.dp))
                Spacer(modifier = Modifier.padding(8.dp))

                Text("Di aplikasi manajemen barang", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.W600, fontFamily = FontFamily.Monospace))
                Spacer(modifier = Modifier.padding(16.dp))


            }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Dashboard(width = 200.dp, height = 200.dp)
                Spacer(modifier = Modifier.padding(20.dp))
//                Text("Update hari ini", style = TextStyle(fontWeight = FontWeight.Bold ))
//                Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {  }
            }
        }
    }







    @Preview
    @Composable
    fun DashboardScreenContentPreview(){
        DashboardScreenContent()
    }

}
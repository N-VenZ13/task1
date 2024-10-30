package com.example.task1.ui.screens

import Dashboard
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.task1.Model.DataUpdate
import com.example.task1.R
import com.example.task1.ui.component.CardUpdate

class DashboardScreen : Screen {
    @Composable
    override fun Content() {
        DashboardScreenContent()
    }

    @Composable
    private fun DashboardScreenContent() {
        Scaffold { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(color = Color(0xFFFFFDE1)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                // Teks sambutan
                Text(
                    text = "Selamat Datang User",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.W600,
                        fontFamily = FontFamily.Monospace
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Logo aplikasi
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "logo",
                    modifier = Modifier.size(width = 240.dp, height = 80.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Di aplikasi manajemen barang",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W600,
                        fontFamily = FontFamily.Monospace
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Dashboard
                Dashboard(width = 200.dp, height = 200.dp)

                Spacer(modifier = Modifier.height(20.dp))

                // Update harian
                Text(
                    text = "Update hari ini",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(start = 16.dp, bottom = 16.dp) // Posisi di pojok kiri atas
                )

                // Daftar CardUpdate
                Column(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CardUpdate(DataUpdate(hari = "Senin", update = "Hari ini beli gula"))
                    CardUpdate(DataUpdate(hari = "Selasa", update = "Hari ini beli gula"))
                    CardUpdate(DataUpdate(hari = "Rabu", update = "Hari ini beli gula"))
                    CardUpdate(DataUpdate(hari = "Kamis", update = "Hari ini beli gula"))
                    CardUpdate(DataUpdate(hari = "Jumat", update = "Hari ini beli gula"))
                    CardUpdate(DataUpdate(hari = "Sabtu", update = "Hari ini beli gula"))
                    CardUpdate(DataUpdate(hari = "Minggu", update = "Hari ini beli gula"))
                }
            }
        }
    }

    @Preview
    @Composable
    fun DashboardScreenContentPreview() {
        DashboardScreenContent()
    }
}

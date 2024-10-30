package com.example.task1.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task1.Model.DataUpdate

@Composable
fun CardUpdate(cardUpdate : DataUpdate){
    var onHari:String
    var onUpdate:String
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2994B2)), // Warna latar belakang biru muda
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            // Teks untuk hari dengan format besar dan tebal
            Text(
                text = cardUpdate.hari,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )

            // Teks untuk update dengan format sedang dan lebih kecil
            Text(
                text = cardUpdate.update,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(top = 4.dp) // Jarak kecil antara hari dan update
            )
        }
    }
}









@Preview
@Composable
fun CardUpdatePreview(){
    var onHari = ""
    var onUpdate = ""
    CardUpdate(cardUpdate = DataUpdate(hari = onHari, update = onUpdate))
}
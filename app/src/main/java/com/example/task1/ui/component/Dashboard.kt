import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Dashboard(
    width: Dp,
    height: Dp
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()

            .padding(16.dp)
            .background(color = Color(0xFFFFFDE1))// Margin untuk konten di dalam
    ) {
        // Tulisan Dashboard di pojok kiri atas
        Text(
            text = "Dashboard",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
                .align(Alignment.TopStart)  // Memposisikan text di pojok kiri atas
        )

        // Row untuk menampilkan 4 card secara horizontal
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),  // Jarak antar Card
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)  // Memposisikan Row di atas
                .padding(top = 50.dp)  // Memberi jarak dari text "Dashboard"
        ) {
            DashboardMenuCard("Tambah Barang")
            DashboardMenuCard("List")
            DashboardMenuCard("History")
            DashboardMenuCard("Stok")
        }
    }
}

// Fungsi untuk membuat Card Menu
@Composable
fun DashboardMenuCard(title: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        modifier = Modifier
            .width(80.dp)
            .height(80.dp)
            .clickable { /* Aksi ketika card diklik */ }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Preview
@Composable
fun DashboardPreview() {
    Dashboard(width = 120.dp, height = 50.dp)
}

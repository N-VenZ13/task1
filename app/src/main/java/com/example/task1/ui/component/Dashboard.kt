import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
            DashboardMenuCard("Tambah", icon = Icons.Default.Add)
            DashboardMenuCard("List", icon = Icons.Default.Menu)
            DashboardMenuCard("History", icon = Icons.Default.CheckCircle)
            DashboardMenuCard("Stok", icon = Icons.Default.ShoppingCart)
        }
    }
}

@Composable
fun DashboardMenuCard(title: String, icon: ImageVector) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2994B2)),
        modifier = Modifier
            .width(80.dp)
            .height(80.dp)
            .clickable { /* Aksi ketika card diklik */ }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Logo di tengah atas Box
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )

                // Teks di tengah bawah Box
                Text(
                    text = title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.padding(bottom = 8.dp),
                    color = Color(0xFF362207)
                )
            }
        }
    }
}

@Preview
@Composable
fun DashboardPreview() {
    Dashboard(width = 120.dp, height = 50.dp)
}

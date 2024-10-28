//import android.widget.Toast
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.example.task1.R
import androidx.compose.ui.platform.LocalContext

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.ui.layout.FirstBaseline


class RegisterScreen : Screen {
    @Composable
    override fun Content() {
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun RegisterScreenContent(
        email: String,
        password: String,
        onEmailChange: (String) -> Unit,
        onPasswordChange: (String) -> Unit,
        nomor: Int,
        nama: String,
        onNomorChange: (Int) -> Unit,
        onNameChange: (String) -> Unit,
    ) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var nomorString by remember { mutableStateOf("") }  // Tetap gunakan String untuk TextField
        var nama by remember { mutableStateOf("") }
        var checkedState by remember { mutableStateOf(false) }
        val context = LocalContext.current

        Scaffold { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(color = Color(0xFFFFFDE1)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.size(width = 240.dp, height = 80.dp)
                )
                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "Selamat Datang",
                    style = TextStyle(fontSize = 24.sp),
                    fontWeight = FontWeight.W600,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier.padding(bottom = 4.dp)
                )

                Text(
                    text = "Masuk untuk mengakses akunmu",
                    style = TextStyle(fontSize = 16.sp),
                    fontWeight = FontWeight.W500,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Spacer(modifier = Modifier.padding(30.dp))

                TextField(
                    value = nama,
                    onValueChange = onNameChange,
                    placeholder = { Text("Masukkan nama anda ") },
                    label = { Text("Nama") },
                    trailingIcon = { Icon(Icons.Filled.Person, contentDescription = "nama") },
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.padding(12.dp))

                TextField(
                    value = email,
                    onValueChange = onEmailChange,
                    placeholder = { Text("Masukkan email anda ") },
                    label = { Text("Email") },
                    trailingIcon = { Icon(Icons.Filled.Email, contentDescription = "email") },
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.padding(12.dp))

                // Untuk nomor telepon
                TextField(
                    value = nomorString,
                    onValueChange = { input ->
                        // Hanya mengubah nomor jika input berupa angka
                        if (input.all { it.isDigit() }) {
                            nomorString = input
                            onNomorChange(input.toInt())
                        }
                    },
                    placeholder = { Text("Masukkan nomor anda ") },
                    label = { Text("Nomor") },
                    trailingIcon = { Icon(Icons.Filled.Phone, contentDescription = "nomor") },
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.padding(12.dp))

                TextField(
                    value = password,
                    onValueChange = onPasswordChange,
                    placeholder = { Text("Masukkan password anda ") },
                    label = { Text("Password") },
                    trailingIcon = { Icon(Icons.Filled.Lock, contentDescription = "password") },
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
//                Spacer(modifier = Modifier.padding(4.dp))

                Row(
                    modifier = Modifier
                        .width(350.dp)
                        .padding(horizontal = 25.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Checkbox(
                        checked = checkedState,
                        onCheckedChange = { checkedState = it },
                        modifier = Modifier.alignBy(FirstBaseline)
                    )
                    Spacer(modifier = Modifier.width(4.dp))

                    val annotatedText = buildAnnotatedString {
                        append("Dengan mencentang kotak, Anda menyetujui ")

                        pushStringAnnotation(
                            tag = "syarat",
//                            annotation = "https://example.com/syarat"
                            annotation = "syarat"
                        )
                        withStyle(style = SpanStyle(color = Color.Blue)) {
                            append("Syarat")
                        }
                        pop()

                        append(" dan ")

                        pushStringAnnotation(
                            tag = "ketentuan",
//                            annotation = "https://example.com/ketentuan"
                            annotation = "ketentuan"
                        )
                        withStyle(style = SpanStyle(color = Color.Blue)) {
                            append("Ketentuan Kami")
                        }
                        pop()
                    }

                    ClickableText(
                        text = annotatedText,
                        onClick = { offset ->
                            annotatedText.getStringAnnotations(
                                tag = "syarat",
                                start = offset,
                                end = offset
                            )
                                .firstOrNull()?.let { annotation ->
                                    // Handle click on "Syarat"
//                                    println("Navigating to: ${annotation.item}")
                                    Toast.makeText(context, "Syarat diklik", Toast.LENGTH_SHORT)
                                        .show()
                                }

                            annotatedText.getStringAnnotations(
                                tag = "ketentuan",
                                start = offset,
                                end = offset
                            )
                                .firstOrNull()?.let { annotation ->
                                    // Handle click on "Ketentuan"
                                    println("Navigating to: ${annotation.item}")
                                }
                        },
                        style = androidx.compose.ui.text.TextStyle(fontSize = 14.sp),
                        modifier = Modifier
                            .padding(top = 8.dp)

                    )
                    Spacer(modifier = Modifier.padding(80.dp))
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {},
                        modifier = Modifier.width(280.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFFFBA746))
                    ) {
                        Text(
                            text = "Register",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }
                    Spacer(modifier = Modifier.padding(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Sudah menjadi anggota? ")
                        Text(
                            text = "Gabung",
                            style = TextStyle(color = Color.Blue),
                            modifier = Modifier.clickable { })
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }

    @Preview
    @Composable
    fun RegisterScreenContentPreview() {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var nama by remember { mutableStateOf("") }
        var nomor by remember { mutableStateOf(0) }

        RegisterScreenContent(
            email = email,
            password = password,
            onEmailChange = { email = it },
            onPasswordChange = { password = it },
            nama = nama,
            nomor = nomor,
            onNameChange = { nama = it },
            onNomorChange = { nomor = it }
        )
    }
}

package com.example.task1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import com.example.task1.R

class LoginScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        LoginScreenContent(navigator)
    }

    @Composable
    private fun LoginScreenContent(
        email: String,
        password: String,
        onEmailChange: (String) -> Unit,
        onPasswordChange: (String) -> Unit
    ) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        // Menggunakan remember untuk menyimpan state dari checkbox
        val checkedState = remember { mutableStateOf(false) }
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
                Spacer(modifier = Modifier.padding(60.dp))

                TextField(
                    value = email,
                    onValueChange = onEmailChange,
                    placeholder = {
                        Text("Masukkan email anda ")
                    },
                    label = {
                        Text("Email")
                    },
                    trailingIcon = { Icon(Icons.Filled.Email, contentDescription = "email") },
                    shape = RoundedCornerShape(8.dp)
                )
                Spacer(modifier = Modifier.padding(16.dp))
                TextField(
                    value = password,
                    onValueChange = onPasswordChange,
                    placeholder = {
                        Text("Masukkan password anda ")
                    },
                    label = {
                        Text("password")
                    },
                    trailingIcon = { Icon(Icons.Filled.Lock, contentDescription = "password") },
                    shape = RoundedCornerShape(8.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp),
                    horizontalArrangement = Arrangement.SpaceBetween // Mengatur item agar terpisah antara kiri dan kanan
                ) {
                    // Checkbox dengan teks "Ingat saya"
                    Row(
                        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = checkedState.value,
                            onCheckedChange = { checkedState.value = it }
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "Ingat saya", fontSize = 14.sp)
                    }

                    // Teks "Lupa Password?" di sebelah kanan
                    Text(
                        text = "Lupa Password?",
                        color = Color.Blue,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(top = 18.dp)
                            .clickable {
                                // Aksi saat teks "Lupa Password?" diklik
                            }
                    )
                }
                Spacer(modifier = Modifier.padding(120.dp))


            }
            Column(
                modifier = Modifier.fillMaxSize(),
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
                        text = "Login",
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
                    Text(text = "Anggota baru? ")
                    Text(
                        text = "Daftar sekarang",
                        style = TextStyle(color = Color.Blue),
                        modifier = Modifier.clickable { })
                }
                Spacer(modifier = Modifier.height(20.dp))
//                Text(text = "Anggota baru?")

            }
        }

    }


    @Preview
    @Composable
    fun LoginScreenContentPreview() {
        var email by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }

        LoginScreenContent(email = email, password = password, onEmailChange = { email = it },
            onPasswordChange = { password = it })
    }


}
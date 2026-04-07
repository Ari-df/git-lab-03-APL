package com.example.bienvenidoalcurso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BienvenidoAlCursoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = Color(0xFFD0F0D0) // Color de fondo verde claro
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Sección de imagen y nombre
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Logo de Android",
                    modifier = Modifier
                        .size(120.dp)
                        .background(Color(0xFF006622)) // Fondo del logo
                )
                Text(
                    text = "Ariana Pauca Leon",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = "Android Developer Extraordinaire",
                    fontSize = 16.sp,
                    color = Color(0xFF006622)
                )
            }

            Spacer(modifier = Modifier.height(100.dp))

            // Sección de información de contacto
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                ContactRow(
                    icon = painterResource(id = R.drawable.ic_phone),
                    text = "9918124479"
                )
                ContactRow(
                    icon = painterResource(id = R.drawable.ic_share),
                    text = "@AndroidDev"
                )
                ContactRow(
                    icon = painterResource(id = R.drawable.ic_email),
                    text = "arianapauca@gmail.com"
                )
            }
        }
    }
}

@Composable
fun ContactRow(icon: androidx.compose.ui.graphics.painter.Painter, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color(0xFF006622))
        )
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BienvenidoAlCursoTheme {
        BusinessCard()
    }
}
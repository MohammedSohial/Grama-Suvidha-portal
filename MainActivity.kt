package com.example.gramasuvidhaportal

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column(
                modifier = Modifier.fillMaxSize().padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text("Grama-Suvidha Portal", style = MaterialTheme.typography.headlineMedium)

                Spacer(Modifier.height(20.dp))

                Button(onClick = {
                    startActivity(Intent(this@MainActivity, DashboardActivity::class.java))
                }) {
                    Text("Enter Dashboard")
                }

                Spacer(Modifier.height(10.dp))

                Button(onClick = {
                    startActivity(Intent(this@MainActivity, AdminActivity::class.java))
                }) {
                    Text("Admin Login")
                }
            }
        }
    }
}
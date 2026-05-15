package com.example.gramasuvidhaportal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class ComplaintActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra("name") ?: ""

        setContent {

            var text by remember { mutableStateOf("") }

            Column(Modifier.padding(16.dp)) {

                Text("Complaint - $name")

                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Write Complaint") }
                )

                Spacer(Modifier.height(10.dp))

                Button(onClick = {
                    DataStore.projects.find { it.name == name }?.complaint = text
                    finish()
                }) {
                    Text("Submit")
                }
            }
        }
    }
}
package com.example.gramasuvidhaportal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class FeedbackActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var text by remember { mutableStateOf("") }

            Column(modifier = Modifier.padding(16.dp)) {

                Text("Feedback Screen")

                Spacer(Modifier.height(10.dp))

                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Write Feedback") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(10.dp))

                Button(onClick = {
                    finish()
                }) {
                    Text("Submit")
                }
            }
        }
    }
}
package com.example.gramasuvidhaportal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AdminActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Column(modifier = Modifier.padding(16.dp)) {

                Text("Admin Dashboard", fontSize = 20.sp)

                Spacer(Modifier.height(10.dp))

                LazyColumn {

                    items(DataStore.projects) { item ->

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {

                            Column(modifier = Modifier.padding(16.dp)) {

                                Text(item.name, fontSize = 16.sp)

                                Text("Complaint: ${item.complaint}")
                                Text("Feedback: ${item.feedback}")

                                Text("Status: ${item.status}")

                                Row {

                                    Button(onClick = {
                                        item.status = "Pending"
                                    }) {
                                        Text("Pending")
                                    }

                                    Spacer(Modifier.width(10.dp))

                                    Button(onClick = {
                                        item.status = "Solved"
                                    }) {
                                        Text("Solved")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
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

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DashboardScreen()
        }
    }
}

/* ---------------- DASHBOARD SCREEN ---------------- */

@Composable
fun DashboardScreen() {

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "Grama-Suvidha Dashboard",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn {

            items(DataStore.projects) { item ->

                ProjectCard(item)

                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

/* ---------------- PROJECT CARD (NO NEW FILE NEEDED) ---------------- */

@Composable
fun ProjectCard(item: DataStore.Item) {

    var showComplaint by remember { mutableStateOf(false) }
    var showFeedback by remember { mutableStateOf(false) }

    var complaintText by remember { mutableStateOf("") }
    var feedbackText by remember { mutableStateOf("") }

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {

            // PROJECT NAME
            Text(item.name, fontSize = 16.sp)

            Spacer(modifier = Modifier.height(6.dp))

            // PROGRESS BAR
            LinearProgressIndicator(
                progress = item.progress,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                "Progress: ${(item.progress * 100).toInt()}% | Status: ${item.status}",
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            // BUTTONS (Complaint + Feedback)
            Row {

                Button(onClick = {
                    showComplaint = !showComplaint
                    showFeedback = false
                }) {
                    Text("Complaint")
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(onClick = {
                    showFeedback = !showFeedback
                    showComplaint = false
                }) {
                    Text("Feedback")
                }
            }

            // ---------------- COMPLAINT ----------------
            if (showComplaint) {

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = complaintText,
                    onValueChange = { complaintText = it },
                    label = { Text("Write Complaint") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(6.dp))

                Button(onClick = {
                    item.complaint = complaintText
                    complaintText = ""
                    showComplaint = false
                }) {
                    Text("Submit Complaint")
                }
            }

            if (item.complaint.isNotEmpty()) {
                Spacer(modifier = Modifier.height(6.dp))
                Text("📢 Complaint: ${item.complaint}")
            }

            // ---------------- FEEDBACK ----------------
            if (showFeedback) {

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = feedbackText,
                    onValueChange = { feedbackText = it },
                    label = { Text("Write Feedback") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(6.dp))

                Button(onClick = {
                    item.feedback = feedbackText
                    feedbackText = ""
                    showFeedback = false
                }) {
                    Text("Submit Feedback")
                }
            }

            if (item.feedback.isNotEmpty()) {
                Spacer(modifier = Modifier.height(6.dp))
                Text("💬 Feedback: ${item.feedback}")
            }
        }
    }
}
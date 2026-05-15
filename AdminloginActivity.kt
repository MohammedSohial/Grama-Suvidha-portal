package com.example.gramasuvidhaportal

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class AdminLoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var phone by remember { mutableStateOf("") }
            var otp by remember { mutableStateOf("") }
            var otpSent by remember { mutableStateOf(false) }
            var verified by remember { mutableStateOf(false) }
            var message by remember { mutableStateOf("") }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                Text("Admin Login", style = MaterialTheme.typography.headlineMedium)

                Spacer(modifier = Modifier.height(10.dp))

                // PHONE INPUT
                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = { Text("Enter Phone Number") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(10.dp))

                // SEND OTP BUTTON
                Button(
                    onClick = {
                        if (phone.length >= 10) {
                            otpSent = true
                            message = "OTP sent successfully (Demo OTP = 1234)"
                        } else {
                            message = "Enter valid phone number"
                        }
                    }
                ) {
                    Text("Send OTP")
                }

                Spacer(modifier = Modifier.height(10.dp))

                if (otpSent) {

                    // OTP INPUT
                    OutlinedTextField(
                        value = otp,
                        onValueChange = { otp = it },
                        label = { Text("Enter OTP") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // VERIFY OTP
                    Button(
                        onClick = {
                            if (otp == "1234") {
                                verified = true
                                message = "Login Successful"
                            } else {
                                message = "Wrong OTP"
                            }
                        }
                    ) {
                        Text("Verify OTP")
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // MESSAGE
                Text(text = message)

                Spacer(modifier = Modifier.height(20.dp))

                // ENTER DASHBOARD BUTTON
                if (verified) {

                    Button(
                        onClick = {
                            startActivity(
                                Intent(
                                    this@AdminLoginActivity,
                                    AdminActivity::class.java
                                )
                            )
                        }
                    ) {
                        Text("Enter Admin Dashboard")
                    }
                }
            }
        }
    }
}
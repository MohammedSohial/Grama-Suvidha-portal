package com.example.gramasuvidhaportal

object DataStore {

    data class Item(
        val name: String,
        var progress: Float,
        var complaint: String = "",
        var feedback: String = "",
        var status: String = "Pending"
    )

    val projects = mutableListOf(
        Item("Road Construction Project", 0.30f),
        Item("Village Water Supply Scheme", 0.45f),
        Item("Electricity Expansion Work", 0.70f),
        Item("Drainage System Upgrade", 0.55f),
        Item("Government School Renovation", 0.40f),
        Item("Primary Health Center Development", 0.25f),
        Item("Smart Village WiFi Installation", 0.60f),
        Item("Street Light Installation", 0.35f),
        Item("Sanitation & Toilet Scheme", 0.50f),
        Item("Agriculture Irrigation System", 0.65f),
        Item("Rural Road Development Phase 2", 0.40f),
        Item("Bus Stand Construction", 0.20f),
        Item("Anganwadi Center Upgrade", 0.55f),
        Item("Solar Energy Village Project", 0.45f),
        Item("Digital Land Records System", 0.30f)
    )
}
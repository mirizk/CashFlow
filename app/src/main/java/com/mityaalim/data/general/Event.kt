package com.mityaalim.data.general

import com.google.firebase.Timestamp

data class Event(
    val id: String,
    val title: String?,
    val description: String?,
    val time: Timestamp?,
    val location: String?
)
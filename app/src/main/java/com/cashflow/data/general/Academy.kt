package com.cashflow.data.general

data class Academy(
    val id: String,
    val title: String?,
    val duration: String? = null,
    val imageUrl: String?,
    val videoUrl: String? = null
)
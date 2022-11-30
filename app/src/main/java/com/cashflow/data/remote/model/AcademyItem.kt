package com.cashflow.data.remote.model

import java.util.*

class AcademyItem(
    val id: String = UUID.randomUUID().toString(),
    val title: String? = null,
    val duration: String? = null,
    val imageUrl: String? = null,
    val videoUrl: String? = null
)
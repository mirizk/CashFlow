package com.mityaalim.data.remote.model

import java.util.*

class InvestmentsItem(
    val id: String = UUID.randomUUID().toString(),
    val title: String? = null,
    val description: String? = null,
    val price: Float? = null,
    val imageUrl: String? = null
)
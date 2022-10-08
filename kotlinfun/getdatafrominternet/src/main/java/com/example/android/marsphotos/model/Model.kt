package com.example.android.marsphotos.model

import com.squareup.moshi.Json

data class MarsPhoto(
    val id: String,
    @Json(name = "img_src") val imageSource: String
)

enum class NetworkStatus {
    LOADING, ERROR, SUCCESS
}

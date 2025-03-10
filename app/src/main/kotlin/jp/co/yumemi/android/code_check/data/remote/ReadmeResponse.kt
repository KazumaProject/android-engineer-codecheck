package jp.co.yumemi.android.code_check.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class ReadmeResponse(
    val name: String,
    val path: String,
    val content: String,
    val encoding: String
)

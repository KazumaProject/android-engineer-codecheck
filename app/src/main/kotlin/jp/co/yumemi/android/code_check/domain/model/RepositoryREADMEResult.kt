package jp.co.yumemi.android.code_check.domain.model

data class RepositoryREADMEResult(
    val name: String,
    val path: String,
    val content: String,
    val encoding: String
)

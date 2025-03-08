package jp.co.yumemi.android.code_check.domain.model

data class RepositorySearchResult(
    val name: String,
    val language: String? = null,
    val stargazersCount: Long,
    val watchersCount: Long,
    val forksCount: Long,
    val openIssuesCount: Long,
    val avatarUrl: String?
)

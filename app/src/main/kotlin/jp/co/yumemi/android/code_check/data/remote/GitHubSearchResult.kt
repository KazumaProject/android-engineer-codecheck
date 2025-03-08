package jp.co.yumemi.android.code_check.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class GitHubSearchResult(
    val items: List<RepoSearchResponse>
)

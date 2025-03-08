package jp.co.yumemi.android.code_check.data.remote

@kotlinx.serialization.Serializable
data class GitHubSearchResult(
    val items: List<RepoSearchResponse>
)

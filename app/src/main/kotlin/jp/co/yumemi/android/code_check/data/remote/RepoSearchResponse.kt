package jp.co.yumemi.android.code_check.data.remote

import kotlinx.parcelize.RawValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RepoSearchResponse(
    @SerialName("full_name") val fullName: String,
    @SerialName("language") val language: String? = null,
    @SerialName("stargazers_count") val stargazersCount: Long,
    @SerialName("watchers_count") val watchersCount: Long,
    @SerialName("forks_count") val forksCount: Long,
    @SerialName("open_issues_count") val openIssuesCount: Long,
    @SerialName("description") val description: String?,
    val owner: @RawValue OwnerResponse?
) {
    @Serializable
    data class OwnerResponse(
        @SerialName("avatar_url") val avatarUrl: String,
        @SerialName("login") val login: String
    )
}

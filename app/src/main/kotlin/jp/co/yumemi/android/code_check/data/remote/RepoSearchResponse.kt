package jp.co.yumemi.android.code_check.data.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@kotlinx.serialization.Serializable
data class RepoSearchResponse(
    @SerialName("full_name") val name: String,
    @SerialName("language") val language: String? = null,
    @SerialName("stargazers_count") val stargazersCount: Long,
    @SerialName("watchers_count") val watchersCount: Long,
    @SerialName("forks_count") val forksCount: Long,
    @SerialName("open_issues_count") val openIssuesCount: Long,
    val owner: @RawValue OwnerResponse?
) : Parcelable {
    @Parcelize
    @Serializable
    data class OwnerResponse(
        @SerialName("avatar_url") val avatarUrl: String
    ) : Parcelable
}

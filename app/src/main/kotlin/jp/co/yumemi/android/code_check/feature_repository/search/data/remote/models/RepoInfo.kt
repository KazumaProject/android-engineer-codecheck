package jp.co.yumemi.android.code_check.feature_repository.search.data.remote.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RepoInfo(
    val name: String,
    val ownerIconUrl: String?,
    val language: String,
    val stargazersCount: Long,
    val watchersCount: Long,
    val forksCount: Long,
    val openIssuesCount: Long,
) : Parcelable

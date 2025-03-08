package jp.co.yumemi.android.code_check.domain.repository

import jp.co.yumemi.android.code_check.data.remote.RepoSearchResponse

interface SearchRepository {
    suspend fun searchRepositories(query: String): List<RepoSearchResponse>
}

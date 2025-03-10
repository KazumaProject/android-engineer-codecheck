package jp.co.yumemi.android.code_check.domain.repository

import jp.co.yumemi.android.code_check.data.remote.ReadmeResponse
import jp.co.yumemi.android.code_check.domain.model.RepositorySearchResult

interface SearchRepository {
    suspend fun searchRepositories(query: String): Result<List<RepositorySearchResult>>
    suspend fun fetchReadme(fullName: String): Result<ReadmeResponse>
}

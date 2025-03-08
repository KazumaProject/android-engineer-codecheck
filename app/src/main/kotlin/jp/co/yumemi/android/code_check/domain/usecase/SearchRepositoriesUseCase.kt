package jp.co.yumemi.android.code_check.domain.usecase

import jp.co.yumemi.android.code_check.data.remote.RepoSearchResponse
import jp.co.yumemi.android.code_check.data.repository.SearchRepositoryImpl
import javax.inject.Inject

class SearchRepositoriesUseCase @Inject constructor(private val searchRepository: SearchRepositoryImpl) {
    suspend fun search(query: String): List<RepoSearchResponse> {
        if (query.isBlank() || query.isEmpty()) return emptyList()
        return searchRepository.searchRepositories(query)
    }
}

package jp.co.yumemi.android.code_check.domain.usecase

import jp.co.yumemi.android.code_check.data.repository.SearchRepositoryImpl
import jp.co.yumemi.android.code_check.domain.model.RepositorySearchResult
import javax.inject.Inject

class SearchRepositoriesUseCase @Inject constructor(private val searchRepository: SearchRepositoryImpl) {
    suspend fun search(query: String): Result<List<RepositorySearchResult>> {
        return searchRepository.searchRepositories(query)
    }
}

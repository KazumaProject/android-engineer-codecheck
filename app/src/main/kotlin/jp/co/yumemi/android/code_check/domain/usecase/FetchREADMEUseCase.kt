package jp.co.yumemi.android.code_check.domain.usecase

import jp.co.yumemi.android.code_check.data.repository.SearchRepositoryImpl
import jp.co.yumemi.android.code_check.domain.model.RepositoryREADMEResult
import javax.inject.Inject

class FetchREADMEUseCase @Inject constructor(private val searchRepository: SearchRepositoryImpl) {
    suspend fun fetchREADME(full_name: String): Result<RepositoryREADMEResult> {
        return searchRepository.fetchReadme(full_name)
    }
}

package jp.co.yumemi.android.code_check.domain.usecase

import jp.co.yumemi.android.code_check.data.remote.ReadmeResponse
import jp.co.yumemi.android.code_check.data.repository.SearchRepositoryImpl
import javax.inject.Inject

class FetchREADMEUseCase @Inject constructor(private val searchRepository: SearchRepositoryImpl) {
    suspend fun fetchREADME(full_name: String): Result<ReadmeResponse> {
        return searchRepository.fetchReadme(full_name)
    }
}

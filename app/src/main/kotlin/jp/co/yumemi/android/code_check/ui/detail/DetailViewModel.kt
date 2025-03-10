package jp.co.yumemi.android.code_check.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.co.yumemi.android.code_check.domain.model.RepositoryREADMEResult
import jp.co.yumemi.android.code_check.domain.usecase.FetchREADMEUseCase
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val fetchREADMEUseCase: FetchREADMEUseCase
) : ViewModel() {
    suspend fun fetchREADME(full_name: String): Result<RepositoryREADMEResult> {
        return withContext(viewModelScope.coroutineContext) {
            fetchREADMEUseCase.fetchREADME(full_name)
        }
    }
}

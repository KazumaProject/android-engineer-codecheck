/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.code_check.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.co.yumemi.android.code_check.data.remote.RepoSearchResponse
import jp.co.yumemi.android.code_check.domain.usecase.SearchRepositoriesUseCase
import kotlinx.coroutines.async
import javax.inject.Inject
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepositoriesUseCase: SearchRepositoriesUseCase
) : ViewModel() {
    suspend fun searchResults(inputText: String): List<RepoSearchResponse> =
        viewModelScope.async {
            return@async searchRepositoriesUseCase.search(inputText)
        }.await()
}

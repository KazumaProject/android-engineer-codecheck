/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.code_check.search

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.call.receive
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import jp.co.yumemi.android.code_check.R
import jp.co.yumemi.android.code_check.domain.model.RepoInfo
import kotlinx.coroutines.async
import org.json.JSONObject
import javax.inject.Inject

/**
 * DetailFragment で使う
 */
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val httpClient: HttpClient
) : ViewModel() {

    // 検索結果
    suspend fun searchResults(inputText: String, context: Context): List<RepoInfo> =
        viewModelScope.async {
            if (inputText.isEmpty()) {
                return@async emptyList()
            }
            val response: HttpResponse =
                httpClient.get("https://api.github.com/search/repositories") {
                    header("Accept", "application/vnd.github.v3+json")
                    parameter("q", inputText)
                }

            val jsonBody = JSONObject(response.body<String>())
            val jsonItems = requireNotNull(jsonBody.optJSONArray("items")) {
                "'items' is missing or not an array in the response JSON."
            }
            val items = mutableListOf<RepoInfo>()
            /**
             * アイテムの個数分ループする
             */
            for (i in 0 until jsonItems.length()) {
                val jsonItem = jsonItems.optJSONObject(i)
                val name = jsonItem.optString("full_name")
                val ownerIconUrl =
                    jsonItem.optJSONObject("owner")?.optString("avatar_url")
                val language = jsonItem.optString("language")
                val stargazersCount = jsonItem.optLong("stargazers_count")
                val watchersCount = jsonItem.optLong("watchers_count")
                val forksCount = jsonItem.optLong("forks_conut")
                val openIssuesCount = jsonItem.optLong("open_issues_count")

                items.add(
                    RepoInfo(
                        name = name,
                        ownerIconUrl = ownerIconUrl,
                        language = context.getString(R.string.written_language, language),
                        stargazersCount = stargazersCount,
                        watchersCount = watchersCount,
                        forksCount = forksCount,
                        openIssuesCount = openIssuesCount
                    )
                )
            }
            return@async items.toList()

        }.await()
}

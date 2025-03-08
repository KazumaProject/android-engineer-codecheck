package jp.co.yumemi.android.code_check.data.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import jp.co.yumemi.android.code_check.data.remote.GitHubSearchResult
import jp.co.yumemi.android.code_check.data.remote.RepoSearchResponse
import jp.co.yumemi.android.code_check.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
) : SearchRepository {
    override suspend fun searchRepositories(query: String): List<RepoSearchResponse> {
        val result: GitHubSearchResult =
            httpClient.get("https://api.github.com/search/repositories") {
                header("Accept", "application/vnd.github.v3+json")
                parameter("q", query)
            }.body()
        return result.items
    }
}

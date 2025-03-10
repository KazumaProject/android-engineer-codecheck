package jp.co.yumemi.android.code_check.data.repository

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import jp.co.yumemi.android.code_check.data.remote.GitHubSearchResult
import jp.co.yumemi.android.code_check.data.remote.ReadmeResponse
import jp.co.yumemi.android.code_check.domain.model.RepositoryREADMEResult
import jp.co.yumemi.android.code_check.domain.model.RepositorySearchResult
import jp.co.yumemi.android.code_check.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
) : SearchRepository {
    override suspend fun searchRepositories(query: String): Result<List<RepositorySearchResult>> =
        runCatching {
            val result: GitHubSearchResult =
                httpClient.get("https://api.github.com/search/repositories") {
                    header("Accept", "application/vnd.github.v3+json")
                    parameter("q", query)
                }.body()
            result.items.map {
                RepositorySearchResult(
                    fullName = it.fullName,
                    language = it.language,
                    stargazersCount = it.stargazersCount,
                    watchersCount = it.watchersCount,
                    forksCount = it.forksCount,
                    openIssuesCount = it.openIssuesCount,
                    avatarUrl = it.owner?.avatarUrl,
                    login = it.owner?.login,
                    description = it.description
                )
            }
        }

    override suspend fun fetchReadme(fullName: String): Result<RepositoryREADMEResult> {
        val url = "https://api.github.com/repos/$fullName/readme"
        return runCatching {
            val result: ReadmeResponse = httpClient.get(url).body()
            RepositoryREADMEResult(
                name = result.name,
                path = result.path,
                content = result.content,
                encoding = result.encoding
            )
        }
    }
}

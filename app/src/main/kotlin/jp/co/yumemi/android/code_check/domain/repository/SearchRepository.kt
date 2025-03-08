package jp.co.yumemi.android.code_check.domain.repository

import io.ktor.client.statement.HttpResponse

interface SearchRepository {
    suspend fun searchRepositories(query: String): HttpResponse
}

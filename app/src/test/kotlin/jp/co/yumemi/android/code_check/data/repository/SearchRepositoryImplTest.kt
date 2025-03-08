package jp.co.yumemi.android.code_check.data.repository

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import io.ktor.utils.io.ByteReadChannel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test

class SearchRepositoryImplTest {

    private lateinit var mockEngine: HttpClientEngine
    private lateinit var httpClient: HttpClient
    private lateinit var repository: SearchRepositoryImpl

    @Before
    fun setUp() {
        mockEngine = MockEngine {
            val fakeResponseBody = """
                {
                    "total_count": 1,
                    "incomplete_results": false,
                    "items": [
                        {
                            "full_name": "MyTestRepo",
                            "language": "Kotlin",
                            "stargazers_count": 42,
                            "watchers_count": 42,
                            "forks_count": 10,
                            "open_issues_count": 5,
                            "owner": {
                                "avatar_url": "https://example.com/avatar.png"
                            }
                        }
                    ]
                }
            """.trimIndent()
            respond(
                content = ByteReadChannel(fakeResponseBody),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        httpClient = HttpClient(mockEngine) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
        repository = SearchRepositoryImpl(httpClient)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `searchRepositories should parse the GitHub response correctly`() = runTest {
        val result = repository.searchRepositories("MyTestRepo")
        val items = result.getOrNull()!!
        assertEquals(1, items.size)
        val firstItem = items.first()
        assertEquals("MyTestRepo", firstItem.fullName)
        assertEquals("Kotlin", firstItem.language)
        assertEquals(42, firstItem.stargazersCount)
        assertEquals(42, firstItem.watchersCount)
        assertEquals(10, firstItem.forksCount)
        assertEquals(5, firstItem.openIssuesCount)
        assertEquals("https://example.com/avatar.png", firstItem.avatarUrl)
    }
}

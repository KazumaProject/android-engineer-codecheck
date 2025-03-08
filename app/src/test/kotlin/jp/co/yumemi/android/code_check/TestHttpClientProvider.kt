package jp.co.yumemi.android.code_check

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import io.ktor.utils.io.ByteReadChannel
import kotlinx.serialization.json.Json

object TestHttpClientProvider {
    private val FAKE_RESPONSE_BODY = """
                {
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

    fun createHttpClient(): HttpClient {
        val mockEngine = MockEngine { _ ->
            respond(
                content = ByteReadChannel(FAKE_RESPONSE_BODY),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        return HttpClient(mockEngine) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
    }
}

package jp.co.yumemi.android.code_check.data.repository

import jp.co.yumemi.android.code_check.TestHttpClientProvider
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class SearchRepositoryImplTest {

    private lateinit var repository: SearchRepositoryImpl

    @Before
    fun setUp() {
        val httpClient = TestHttpClientProvider.createHttpClient()
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

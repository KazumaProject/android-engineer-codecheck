package jp.co.yumemi.android.code_check.domain.usecase

import com.kazumaproject.core_testing.TestHttpClientProvider
import jp.co.yumemi.android.code_check.data.repository.SearchRepositoryImpl
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class SearchRepositoriesUseCaseTest {

    private lateinit var searchRepositoriesUseCase: SearchRepositoriesUseCase

    @Before
    fun setUp() {
        val httpClient = TestHttpClientProvider.createHttpClient()
        val searchRepository = SearchRepositoryImpl(httpClient)
        searchRepositoriesUseCase = SearchRepositoriesUseCase(searchRepository)
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `search returns correctly mapped repository results`() = runTest {
        val result = searchRepositoriesUseCase.search("MyTest")

        assertTrue(result.isSuccess)
        val repositoryList = result.getOrNull()
        assertNotNull(repositoryList)
        assertEquals(1, repositoryList?.size)

        val mappedResult = repositoryList?.first()
        mappedResult?.apply {
            assertEquals("MyTestRepo", fullName)
            assertEquals("Kotlin", language)
            assertEquals(42, stargazersCount)
            assertEquals(42, watchersCount)
            assertEquals(10, forksCount)
            assertEquals(5, openIssuesCount)
            assertEquals("https://example.com/avatar.png", avatarUrl)
        }
    }
}

package jp.co.yumemi.android.code_check.ui.search

import com.kazumaproject.core_testing.TestHttpClientProvider
import jp.co.yumemi.android.code_check.data.repository.SearchRepositoryImpl
import jp.co.yumemi.android.code_check.domain.usecase.SearchRepositoriesUseCase
import junit.framework.TestCase
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SearchViewModelTest {

    private lateinit var searchViewModel: SearchViewModel
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        val httpClient = TestHttpClientProvider.createHttpClient()
        val searchRepository = SearchRepositoryImpl(httpClient)
        val searchRepositoryUseCase = SearchRepositoriesUseCase(searchRepository)
        searchViewModel = SearchViewModel(searchRepositoryUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test for searchResults in SearchViewModel`() = runTest {
        testDispatcher.scheduler.advanceUntilIdle()
        val result = searchViewModel.searchResults("MyTest")
        assertTrue(result.isSuccess)
        val items = result.getOrNull()!!
        val firstItem = items.first()
        TestCase.assertEquals("MyTestRepo", firstItem.fullName)
        TestCase.assertEquals("Kotlin", firstItem.language)
        TestCase.assertEquals(42, firstItem.stargazersCount)
        TestCase.assertEquals(42, firstItem.watchersCount)
        TestCase.assertEquals(10, firstItem.forksCount)
        TestCase.assertEquals(5, firstItem.openIssuesCount)
        TestCase.assertEquals("https://example.com/avatar.png", firstItem.avatarUrl)
    }

}



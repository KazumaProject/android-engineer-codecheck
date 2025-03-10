package jp.co.yumemi.android.code_check.di

import com.kazumaproject.core_testing.TestHttpClientProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import io.ktor.client.HttpClient

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [NetworkModule::class]
)
object TestNetworkModule {
    @Provides
    fun provideHttpClient(): HttpClient {
        return TestHttpClientProvider.createHttpClient()
    }
}

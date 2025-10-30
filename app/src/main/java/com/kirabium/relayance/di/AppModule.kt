package com.openclassrooms.hexagonal.games.di

import com.kirabium.relayance.data.service.CustomerApi
import com.kirabium.relayance.data.service.DummyData
import com.oliviermarteaux.shared.utils.AndroidLogger
import com.oliviermarteaux.shared.utils.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * This class acts as a Dagger Hilt module, responsible for providing dependencies to other parts of the application.
 * It's installed in the SingletonComponent, ensuring that dependencies provided by this module are created only once
 * and remain available throughout the application's lifecycle.
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
  /**
   * Provides a Singleton instance of CustomerApi using a DummyData implementation for testing purposes.
   * This means that whenever a dependency on CustomerApi is requested, the same instance of DummyData will be used
   * throughout the application, ensuring consistent data for testing scenarios.
   *
   * @return A Singleton instance of DummyData.
   */
  @Provides
  @Singleton
  fun provideCustomerApi(): CustomerApi {
    return DummyData // to be replaced for test
  }

  /**
   * Provides a singleton instance of [Logger].
   *
   * @return A singleton instance of [AndroidLogger].
   */
  @Provides
  @Singleton
  fun provideLogger(): Logger = AndroidLogger

}
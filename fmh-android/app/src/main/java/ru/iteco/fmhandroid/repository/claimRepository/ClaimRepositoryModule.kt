package ru.iteco.fmhandroid.repository.claimRepository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class ClaimRepositoryModule {
    @Binds
    abstract fun bindClaimRepository(imp: ClaimRepositoryImpl): ClaimRepository
}

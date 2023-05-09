package com.example.comprass.di.module

import com.example.comprass.data.repository.ProductRepositoryImpl
import com.example.comprass.data.repository.UserRepositoryImpl
import com.example.comprass.domain.repository.ProductRepository
import com.example.comprass.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class InterfaceModule {
    @Binds
    abstract fun bindProductRepository(repositoryImpl: ProductRepositoryImpl):ProductRepository

    @Binds
    abstract  fun bindUserRepositoty( userRepositoryImpl: UserRepositoryImpl):UserRepository
 }
package com.example.comprass.di.module

import android.content.Context
import com.example.comprass.data.local.helper.ComprasDatabase
import com.example.comprass.data.repository.ProductRepositoryImpl
import com.example.comprass.data.repository.UserRepositoryImpl
import com.example.comprass.domain.repository.ProductRepository
import com.example.comprass.domain.repository.UserRepository
import com.example.comprass.domain.usecase.usecaseimpl.UserCrudUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityComponent::class)
class AppModule {

    @Provides
    fun provideUserRepository(db :ComprasDatabase):UserRepositoryImpl{
        return  UserRepositoryImpl(db)
    }

    @Provides
    fun providesProductRepositoty(db:ComprasDatabase):ProductRepositoryImpl{
          return ProductRepositoryImpl(db)
    }

    @Provides
    fun provideRoomDataBase(@ApplicationContext context: Context):ComprasDatabase{
            return ComprasDatabase.getDataBase(context)
    }
}
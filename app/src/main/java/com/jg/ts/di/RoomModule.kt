package com.jg.ts.di

import android.content.Context
import androidx.room.Room
import com.jg.ts.data.local.database.TSDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "TSDatabase"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context, TSDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideSectionDao(db: TSDatabase) = db.getSectionDao()

}
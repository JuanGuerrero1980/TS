package com.jg.ts.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jg.ts.data.local.database.dao.SectionDao
import com.jg.ts.data.local.database.entities.SectionEntity

@Database(entities = [SectionEntity::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverter::class)
abstract class TSDatabase: RoomDatabase() {

    abstract fun getSectionDao(): SectionDao
}
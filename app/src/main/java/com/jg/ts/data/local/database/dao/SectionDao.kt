package com.jg.ts.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jg.ts.data.local.database.entities.SectionEntity

@Dao
interface SectionDao {

    @Query("SELECT * FROM section_table")
    suspend fun getAllSections(): List<SectionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(sections: List<SectionEntity>)

}
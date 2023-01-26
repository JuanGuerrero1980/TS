package com.jg.ts.data.local

import com.jg.ts.data.local.database.dao.SectionDao
import com.jg.ts.data.local.database.entities.SectionEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val sectionDao: SectionDao
) {

    suspend fun getAllSections(): List<SectionEntity> {
        return sectionDao.getAllSections()
    }

    suspend fun insertAllSections(list: List<SectionEntity>) {
        sectionDao.insertAll(list)
    }

}
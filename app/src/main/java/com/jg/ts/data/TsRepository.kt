package com.jg.ts.data

import com.jg.ts.data.model.CategoryModel
import com.jg.ts.domain.model.Section

interface TsRepository {

    suspend fun getAllCategories(): List<CategoryModel>

    suspend fun getAllSectionsFromApi() : List<Section>

    suspend fun getAllSectionsFromDB() : List<Section>

    suspend fun insertAllSections(list: List<Section>)

}
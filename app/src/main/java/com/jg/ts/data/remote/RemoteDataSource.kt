package com.jg.ts.data.remote

import com.jg.ts.data.model.CategoryModel
import com.jg.ts.data.model.SectionModel
import com.jg.ts.data.remote.mapper.Mapper
import com.jg.ts.data.remote.service.TsAPIService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val service: TsAPIService,
    private val mapper: Mapper
) {

    suspend fun getAllCategories(): List<CategoryModel> {
        val list = service.getAllCategories()
        list.body()?.let {
            mapper.categoryResponseToCategoryModel(it)
        }
        return emptyList()
    }

    suspend fun getAllSections(): List<SectionModel> {
        val list = service.getSections()

        return list.body()?.let {
            it.response.map { section -> mapper.sectionResponseToSectionModel(section) }
        } ?: kotlin.run {
            emptyList()
        }
    }
}
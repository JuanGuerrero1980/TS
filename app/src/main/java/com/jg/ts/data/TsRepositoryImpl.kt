package com.jg.ts.data

import com.jg.ts.data.local.LocalDataSource
import com.jg.ts.data.local.database.entities.SectionEntity
import com.jg.ts.data.model.CategoryModel
import com.jg.ts.data.remote.RemoteDataSource
import com.jg.ts.domain.model.Section
import com.jg.ts.domain.model.toDomain
import com.jg.ts.domain.model.toEntity
import javax.inject.Inject

class TsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
    ): TsRepository {

    override suspend fun getAllCategories(): List<CategoryModel> {
        return remoteDataSource.getAllCategories()
    }

    override suspend fun getAllSectionsFromApi(): List<Section> {
        val listModel = remoteDataSource.getAllSections()
        val listSections = mutableListOf<Section>()
        listModel.forEach {
            val section = it.toDomain()
            section.subsections.addAll(it.subsections.map { model-> model.toDomain() })
            listSections.add(section)
        }
        return listSections
    }

    override suspend fun getAllSectionsFromDB(): List<Section> {
        val sectionsEntities = localDataSource.getAllSections()
        val sections = mutableListOf<Section>()
        sectionsEntities.forEach {
            if(it.parentID == null){
                sections.add(it.toDomain())
            }
        }
        sectionsEntities.forEach {
            it.parentID?.let { _ ->
                sections.first { section -> section.id == it.parentID }.subsections.add(it.toDomain())
            }
        }
        return sections
    }

    override suspend fun insertAllSections(list: List<Section>) {
        val entities = mutableListOf<SectionEntity>()

        list.forEach {
            entities.add(it.toEntity(null))
            it.subsections.forEach { subsection ->
                val entity = subsection.toEntity(it.id)
                entities.add(entity)
            }
        }
        localDataSource.insertAllSections(entities)
    }


}
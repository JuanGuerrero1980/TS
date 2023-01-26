package com.jg.ts.domain.model

import com.jg.ts.data.local.database.entities.SectionEntity
import com.jg.ts.data.model.SectionModel

data class Section(
    val id: Int,
    val label: String,
    val landing: Int,
    val tid: Int,
    val webUrl: String,
    val adExtras: MutableMap<String, String>,
    val subsections: MutableList<Section> = mutableListOf()
)

fun SectionModel.toDomain() = Section(id = id, label = label, landing = landing, tid = tid, webUrl = webUrl, adExtras = adExtras)

fun SectionEntity.toDomain() = Section(id = id, label = label, landing = landing, tid = tid, webUrl = webUrl, adExtras = adExtras)

fun Section.toEntity(parentId: Int?) = SectionEntity(id = id, label = label, landing = landing, tid = tid, webUrl = webUrl, adExtras = adExtras, parentID = parentId)

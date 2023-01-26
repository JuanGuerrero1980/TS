package com.jg.ts.data.local.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "section_table")
data class SectionEntity(@PrimaryKey
                         @ColumnInfo(name = "id") val id: Int,
                         @ColumnInfo(name = "label") val label: String,
                         @ColumnInfo(name = "landing") val landing: Int,
                         @ColumnInfo(name = "tid") val tid: Int,
                         @ColumnInfo(name = "webUrl") val webUrl: String,
                         @ColumnInfo(name = "adExtras") val adExtras: MutableMap<String, String>,
                         @ColumnInfo(name = "parentID") val parentID: Int?)
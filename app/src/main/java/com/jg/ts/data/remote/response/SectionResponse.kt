package com.jg.ts.data.remote.response

data class SectionResponse(
    val id: Int,
    val label: String,
    val landing: Int,
    val tid: Int,
    val webUrl: String,
    val adExtras: MutableMap<String, String>,
    val subsections: MutableList<SectionResponse>?
)

data class SectionsResponse(val response: List<SectionResponse>)
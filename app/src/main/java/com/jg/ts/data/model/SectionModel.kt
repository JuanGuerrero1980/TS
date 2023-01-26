package com.jg.ts.data.model

data class SectionModel(val id: Int,
                        val label: String,
                        val landing: Int,
                        val tid: Int,
                        val webUrl: String,
                        val adExtras: MutableMap<String, String>,
                        val subsections: MutableList<SectionModel>)
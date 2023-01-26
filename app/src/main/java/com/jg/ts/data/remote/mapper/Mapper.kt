package com.jg.ts.data.remote.mapper

import com.jg.ts.data.model.CategoryModel
import com.jg.ts.data.model.SectionModel
import com.jg.ts.data.remote.response.CategoryResponse
import com.jg.ts.data.remote.response.SectionResponse

class Mapper {

    fun categoryResponseToCategoryModel(categoryResponse: CategoryResponse) : CategoryModel = with(categoryResponse){
        CategoryModel(this.name)
    }

    fun sectionResponseToSectionModel(sectionResponse: SectionResponse) : SectionModel = with(sectionResponse) {
        val subSections = mutableListOf<SectionModel>()
        this.subsections?.let {
            for (section in this.subsections){
                subSections.add(sectionResponseToSectionModel(section))
            }
        }
        SectionModel(this.id, this.label, this.landing, this.tid, this.webUrl, this.adExtras, subSections)
    }
}
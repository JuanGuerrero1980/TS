package com.jg.ts.data.remote.service

import com.jg.ts.data.remote.response.CategoryResponse
import com.jg.ts.data.remote.response.SectionsResponse
import retrofit2.Response
import retrofit2.http.GET

interface TsAPIService {

    @GET("")
    suspend fun getAllCategories() : Response<CategoryResponse>

    @GET("getSections")
    suspend fun getSections() : Response<SectionsResponse>

}
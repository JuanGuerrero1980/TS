package com.jg.ts.domain

import com.jg.ts.common.SafeFunctionExecutor
import com.jg.ts.common.TsResult
import com.jg.ts.data.TsRepository
import com.jg.ts.domain.model.Section
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetAllSectionsFromAPIUseCase @Inject constructor(
    private val repository: TsRepository,
    private val safeFunctionExecutor: SafeFunctionExecutor
) {

    suspend operator fun invoke(): TsResult<List<Section>> {
        return safeFunctionExecutor.executeSafeFunction {
            repository.getAllSectionsFromApi()
        }
    }

}
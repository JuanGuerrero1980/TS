package com.jg.ts.presentation.home

import androidx.lifecycle.viewModelScope
import com.jg.ts.common.BaseViewModel
import com.jg.ts.common.TsResult
import com.jg.ts.domain.GetAllSectionsFromAPIUseCase
import com.jg.ts.domain.GetAllSectionsFromDBUseCase
import com.jg.ts.domain.SaveAllSectionsToDBUseCase
import com.jg.ts.domain.model.Section
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllSectionsFromAPIUseCase: GetAllSectionsFromAPIUseCase,
    private val getAllSectionsFromDBUseCase: GetAllSectionsFromDBUseCase,
    private val saveAllSectionsToDBUseCase: SaveAllSectionsToDBUseCase
) : BaseViewModel<HomeUIState, HomeNavigation>(HomeUIState.Initial) {

    fun getAllSectionsFromDB() = viewModelScope.launch {
        setViewState(HomeUIState.Loading)
        when(val result = getAllSectionsFromDBUseCase()){
            is TsResult.Success -> showSections(result.result)
            is TsResult.Error -> showError(result.error.message)
        }
    }

    private fun showError(message: String) {
        setViewState(HomeUIState.ShowError(message))
    }

    private fun showSections(result: List<Section>) {
        if(result.isEmpty()){
            getSectionsFromApi()
        } else {
            setViewState(HomeUIState.ShowSections(result))
        }

    }

    private fun getSectionsFromApi() = viewModelScope.launch {
        when(val result = getAllSectionsFromAPIUseCase()){
            is TsResult.Success -> saveAndShowSections(result.result)
            is TsResult.Error -> showError(result.error.message)
        }
    }

    private suspend fun saveAndShowSections(list: List<Section>) {
        when(val result = saveAllSectionsToDBUseCase.invoke(list)){
            is TsResult.Error -> showError(result.error.message)
            is TsResult.Success -> getAllSectionsFromDB()
        }
    }

    fun getAllSectionsFromApi() {
        setViewState(HomeUIState.Loading)
        getSectionsFromApi()
    }

}
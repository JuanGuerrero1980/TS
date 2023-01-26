package com.jg.ts.presentation.home

import com.jg.ts.domain.model.Section

sealed class HomeUIState {

    data class ShowSections(val list: List<Section>) : HomeUIState()
    data class ShowError(val message: String) : HomeUIState()
    object Initial : HomeUIState()
    object Loading : HomeUIState()
}

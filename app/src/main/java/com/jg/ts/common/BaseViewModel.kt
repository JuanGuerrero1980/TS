package com.jg.ts.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<VS, N>(
    initialState: VS,
) : ViewModel() {

    private val _viewState = MutableStateFlow(initialState)
    val viewState: StateFlow<VS>
        get() = _viewState

    private val _navigation = MutableSharedFlow<N>()
    val navigation: SharedFlow<N>
        get() = _navigation

    protected fun setViewState(viewState: VS) {
        _viewState.value = viewState
    }

    protected fun getViewState(): VS {
        return _viewState.value
    }

    protected suspend fun navigate(navigation: N) {
        _navigation.emit(navigation)
    }

    protected fun updateViewState(reducer: (VS) -> VS) {
        _viewState.value.run { _viewState.value = reducer(this) }
    }
}
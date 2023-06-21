package com.example.a6monthlesson1.data.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a6monthlesson1.domain.Resource
import com.example.a6monthlesson1.presentation.utils.UIState
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseViewModel: ViewModel() {

    protected fun <T> Flow<Resource<T>>.collectData(
        _state: MutableStateFlow<UIState<T>>
    ){
        viewModelScope.launch {
            this@collectData.collect{ res ->
                when (res) {
                    is Resource.Error -> {
                        _state.value = UIState.Error(res.message!!)
                    }
                    is Resource.Loading -> {
                        _state.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (res.data != null)
                            _state.value = UIState.Success(res.data)
                    }
                }
            }
        }
    }

}
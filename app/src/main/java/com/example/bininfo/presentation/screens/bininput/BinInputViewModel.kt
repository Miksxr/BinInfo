package com.example.bininfo.presentation.screens.bininput

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bininfo.domain.model.BinInfoModel
import com.example.bininfo.domain.usecase.FetchBinInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BinInputViewModel @Inject constructor(private val fetchBinInfoUseCase: FetchBinInfoUseCase) : ViewModel() {
    private val _result = MutableStateFlow<BinInfoModel?>(null)
    val result: StateFlow<BinInfoModel?> get() = _result

    fun fetchBinInfo(bin: String) {
        viewModelScope.launch {
            try {
                _result.value = fetchBinInfoUseCase(bin)
            } catch (e: Exception) {
                _result.value = null
            }
        }
    }
}

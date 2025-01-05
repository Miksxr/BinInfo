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
class BinInputViewModel @Inject constructor(
    private val fetchBinInfoUseCase: FetchBinInfoUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(BinInputState())
    val state: StateFlow<BinInputState> = _state

    fun fetchBinInfo(bin: String) {
        viewModelScope.launch {
            try {
                val binInfo = fetchBinInfoUseCase(bin)
                _state.value = _state.value.copy(binInfo = binInfo)
            } catch (e: Exception) {
                _state.value = _state.value.copy(error = "Failed to fetch BIN info")
            }
        }
    }

    data class BinInputState(
        val binInfo: BinInfoModel? = null,
        val error: String? = null
    )
}
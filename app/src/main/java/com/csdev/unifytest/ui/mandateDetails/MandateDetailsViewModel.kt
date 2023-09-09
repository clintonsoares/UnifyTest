package com.csdev.unifytest.ui.mandateDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csdev.unifytest.domain.useCase.mock.GetMockUseCase
import com.csdev.unifytest.utils.enums.PaymentOption
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MandateDetailsViewModel @Inject constructor(
    private val getMockUseCase: GetMockUseCase
) : ViewModel() {

    private val _selectedPaymentOption: MutableStateFlow<PaymentOption?> = MutableStateFlow(null)
    val selectedPaymentOption: StateFlow<PaymentOption?> = _selectedPaymentOption

    fun onPaymentOptionSelected(option: PaymentOption) {
        viewModelScope.launch {
            _selectedPaymentOption.emit(option)
        }
    }

    fun getMockData() {
        viewModelScope.launch {
            getMockUseCase.getMockData().collect {
                val data = it
                // do something with data
            }
        }
    }

}
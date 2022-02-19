package org.mascota.user.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch
import org.mascota.core.util.MutableEventFlow
import org.mascota.core.util.asEventFlow

@HiltViewModel
class UserViewModel @Inject constructor() : ViewModel() {
    private var email = ""
    private val _signUpBtnEnableEvent = MutableEventFlow<Boolean>()
    val signUpBtnEnableEvent
        get() = _signUpBtnEnableEvent.asEventFlow()

    private val _signUpBtnTextChangeEvent = MutableEventFlow<Boolean>()
    val signUpBtnTextChangeEvent
        get() = _signUpBtnTextChangeEvent.asEventFlow()

    fun setBtnEnableEvent(isEnable: Boolean) {
        viewModelScope.launch {
            _signUpBtnEnableEvent.emit(isEnable)
        }
    }

    fun setBtnTextChangeEvent(isChange: Boolean) {
        viewModelScope.launch {
            _signUpBtnTextChangeEvent.emit(isChange)
        }
    }

    fun setEmail(email: String) {
        this.email = email
    }

    fun getEmail() = email
}

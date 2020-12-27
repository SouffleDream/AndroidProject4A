package com.esiea.androidproject.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.androidproject.domain.entity.User
import com.esiea.androidproject.domain.usecase.CreateUserUseCase
import com.esiea.androidproject.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    val counter : MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value = 0
    }

    fun onClickedIncrement(emailUser: String) {
        viewModelScope.launch(Dispatchers.IO) {
            createUserUseCase.invoke(User(emailUser))
            val user = getUserUseCase.invoke(emailUser)
        }
    }
}
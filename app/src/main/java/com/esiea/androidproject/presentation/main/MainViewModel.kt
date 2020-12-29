package com.esiea.androidproject.presentation.main

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.androidproject.domain.entity.User
import com.esiea.androidproject.domain.usecase.CreateUserUseCase
import com.esiea.androidproject.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val getUserUseCase: GetUserUseCase,
    private val createUserUseCase: CreateUserUseCase
) : ViewModel() {
    val loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user =getUserUseCase.invoke(emailUser, password)
            val loginStatus = if (user != null && (emailUser != "" || password != "")){
                LoginSuccess(user.email, user.password)
            } else {
                LoginError
            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }
        }
    }

    fun onChangeView(){
    }

    fun onClickedCreateAccount(emailUser: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            val user =createUserUseCase.invoke(User(emailUser, password))
        }
    }
}
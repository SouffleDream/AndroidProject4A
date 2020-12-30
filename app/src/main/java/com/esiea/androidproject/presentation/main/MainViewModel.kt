package com.esiea.androidproject.presentation.main

import android.content.Context
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
    val verifLiveData : MutableLiveData<VerifStatus> = MutableLiveData()

    fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user =getUserUseCase.invoke(emailUser, password)
            val loginStatus = if (user != null && (emailUser.isNotEmpty() && password.isNotEmpty())){
                LoginSuccess(user.email, user.password)
            } else {
                LoginError
            }
            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }
        }
    }

    fun onClickedCreateAccount(emailUser: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(emailUser, password)
            val verifStatus = if (user != null && (emailUser.isNotEmpty() || password.isNotEmpty())){
                VerifSuccess(user.email, user.password)
            } else {
                VerifError
            }
            withContext(Dispatchers.Main){
                verifLiveData.value = verifStatus
            }
        }
    }

    fun createdAccount(emailUser: String, password: String, context: Context){
        viewModelScope.launch(Dispatchers.IO) {
                createUserUseCase.invoke(User(emailUser, password))
        }
    }
}
package com.esiea.androidproject.domain.usecase

import com.esiea.androidproject.data.repository.UserRepository
import com.esiea.androidproject.domain.entity.User

class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)
    }
}
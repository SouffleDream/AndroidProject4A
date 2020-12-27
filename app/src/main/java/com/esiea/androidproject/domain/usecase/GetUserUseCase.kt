package com.esiea.androidproject.domain.usecase

import com.esiea.androidproject.data.repository.UserRepository
import com.esiea.androidproject.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String) : User {
        return userRepository.getUser(email)
    }
}
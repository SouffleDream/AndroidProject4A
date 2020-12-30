package com.esiea.androidproject.domain.usecase

import com.esiea.androidproject.data.repository.UserRepository
import com.esiea.androidproject.domain.entity.User
import com.esiea.androidproject.domain.usecase.CreateUserUseCase
import io.mockk.mockk
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CreateUserUseCaseTest{
    private val userRepository: UserRepository = mockk()

    private val classUnderTest = CreateUserUseCase(userRepository)

    @Test
    fun invoke(){
        runBlocking {
            //GIVEN
            val user = User("","")
            coEvery { userRepository.createUser(user)} returns Unit

            //WHEN
            classUnderTest.invoke(user)

            //THEN
            coVerify(exactly = 1) { userRepository.createUser(user) }
        }
    }
}
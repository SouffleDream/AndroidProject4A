package com.esiea.androidproject.domain.usecase

import com.esiea.androidproject.data.repository.UserRepository
import com.esiea.androidproject.domain.entity.User
import com.esiea.androidproject.domain.usecase.CreateUserUseCase
import com.esiea.androidproject.domain.usecase.GetUserUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetUserUseCaseTest{
    private val userRepository: UserRepository = mockk()

    private val classUnderTest = GetUserUseCase(userRepository)

    @Test
    fun `invoke with invalid informations`(){
        runBlocking {
            //GIVEN
            val email = ""
            val password = ""
            coEvery { userRepository.getUser(email, password)} returns null

            //WHEN
            val resul = classUnderTest.invoke(email, password)

            //THEN
            coVerify(exactly = 1) { userRepository.getUser(email, password) }
            assertEquals(resul, null)
        }
    }

    @Test
    fun `invoke with valid informations`() {
        runBlocking {
            //GIVEN
            val email = "aze@aze.com"
            val password = "aze"
            val exceptedUser = User("aze@aze.com", "aze")
            coEvery { userRepository.getUser(email, password) } returns exceptedUser

            //WHEN
            val resul = classUnderTest.invoke(email, password)

            //THEN
            coVerify(exactly = 1) { userRepository.getUser(email, password) }
            assertEquals(resul, exceptedUser)
        }
    }
}
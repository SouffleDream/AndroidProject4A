package com.esiea.androidproject.data.repository

import com.esiea.androidproject.data.local.DatabaseDao
import com.esiea.androidproject.data.local.models.toData
import com.esiea.androidproject.data.local.models.toEntity
import com.esiea.androidproject.domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao
) {
    suspend fun createUser(user : User) {
        databaseDao.insert(user.toData())
    }

    fun getUser(email : String, password : String) : User? {
        val userLocal = databaseDao.findByName(email, password)
        return userLocal?.toEntity()
    }
}
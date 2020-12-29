package com.esiea.androidproject.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.esiea.androidproject.domain.entity.User

@Entity
data class UserLocal(
    @PrimaryKey(autoGenerate = true) var uid: Int? = null,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String
) {
    constructor() : this(null,"", "")
}

fun User.toData() : UserLocal {
    return UserLocal(
        email = email,
        password = password
    )
}

fun UserLocal.toEntity() : User {
    return User(
        email = email,
        password = password
    )
}
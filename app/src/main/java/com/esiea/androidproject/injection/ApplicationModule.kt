package com.esiea.androidproject.injection

import android.content.Context
import androidx.room.Room
import com.esiea.androidproject.data.local.AppDatabase
import com.esiea.androidproject.data.local.DatabaseDao
import com.esiea.androidproject.data.repository.UserRepository
import com.esiea.androidproject.domain.usecase.CreateUserUseCase
import com.esiea.androidproject.domain.usecase.GetUserUseCase
import com.esiea.androidproject.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel(get(), get()) }
}

val domainModule = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule = module {
    single { UserRepository(get()) }
    single { creteDataBase(androidContext()) }
}

fun creteDataBase(context: Context): DatabaseDao {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}

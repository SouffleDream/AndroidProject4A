package com.esiea.androidproject.Injection

import com.esiea.androidproject.MainViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel() }
}
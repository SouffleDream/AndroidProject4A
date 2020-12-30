package com.esiea.androidproject.presentation.main


sealed class VerifStatus

data class VerifSuccess(val email: String, val password: String) : VerifStatus()

object VerifError : VerifStatus()
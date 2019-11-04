package com.quoders.android.app.madridbus.domain.login

interface LoginController {

    fun login(user: String, password: String) : String
}

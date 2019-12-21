package com.quoders.android.app.madridbus.data.login

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test


class LoginRepositoryTest {

    @Test
    fun given_userNotLogedIn_when_LogIn_then_loginSuccess() {

        val server = MockWebServer()
        server.enqueue(MockResponse().setBody("hello, world!"))

        server.start()

        val baseUrl = server.url("/v1/chat/")


    }
}
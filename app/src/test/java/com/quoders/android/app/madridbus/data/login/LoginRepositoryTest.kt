package com.quoders.android.app.madridbus.data.login

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.willReturn
import com.quoders.android.app.madridbus.data.DataFixtures
import com.quoders.android.app.madridbus.data.LoginRepositoryImpl
import com.quoders.android.app.madridbus.data.remote.EmtService
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginRepositoryTest {

    @Mock
    internal lateinit var mockEmtService: EmtService

    private lateinit var loginRepository: LoginRepositoryImpl
    private val user = "fake_user"
    private val password = "fake_password"

    @Before
    fun setup() {
        loginRepository = LoginRepositoryImpl(mockEmtService)
    }

    @Test
    fun given_userNotLogedIn_when_LogIn_then_returnValidToken() {
        runBlocking {

            // given
            given(mockEmtService.login(user, password)).willReturn {
                DataFixtures.getSuccessLoginData(user, password)
            }

            //  when
            val userToken = loginRepository.getUserToken(user, password)

            //  then
            assertEquals(userToken, "2ae5f584-2634-403e-a5ec-60bbe3ab7065")
        }
    }

    @Test
    fun given_userNotLoginIn_when_logIn_and_userDataIncorrect_then_returnLoginError() {
        runBlocking {

            // given
            given(mockEmtService.login(user, password)).willReturn {
                DataFixtures.getUserAuthFailedData()
            }

            //  when
            val userToken = loginRepository.getUserToken(user, password)

            //  then
            assertEquals(userToken, "2ae5f584-2634-403e-a5ec-60bbe3ab7065")
        }
    }

}
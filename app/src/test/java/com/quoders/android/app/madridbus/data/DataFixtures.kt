package com.quoders.android.app.madridbus.data

import com.quoders.android.app.madridbus.data.login.ApiCounter
import com.quoders.android.app.madridbus.data.login.LoginApiData
import com.quoders.android.app.madridbus.data.login.UserData

object DataFixtures {

    internal fun getSuccessLoginData(
        user: String = "fake@user.com",
        password: String = "fake_password"
    ): LoginApiData {

        val userData = mutableListOf<UserData>()
        userData.add(
            UserData(
                updatedAt = "2019-02-07T22:11:52.7430000",
                userName = "WEB.SERV.${user}",
                accessToken = "2ae5f584-2634-403e-a5ec-60bbe3ab7065",
                tokenSecExpiration = 86399,
                email = user,
                idUser = "7307019c-2014-46a0-b02a-4408cd9635d0",
                apiCounter = ApiCounter(
                    current = 0,
                    dailyUse = 250000
                )
            )
        )

        return LoginApiData(
            code = "00",
            description = "Register user: WEB.SERV.fake@user.com.com with token: 2ae5f584-2634-403e-a5ec-60bbe3ab7065 ",
            datetime = "2020-01-05T00:17:21.105176",
            userData = userData
        )
    }

    internal fun getUserAuthFailedData() =
        LoginApiData(
            code = "80",
            description = "Invalid user or password",
            datetime = "2020-01-05T01:02:53.487068",
            userData = emptyList()
        )

    internal fun getServerErrorData() =
        LoginApiData(
            code = "",
            description = "",
            datetime = "",
            userData = emptyList()
        )
}
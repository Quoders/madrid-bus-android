package com.quoders.android.app.madridbus.login

import com.quoders.android.app.madridbus.core.functional.Failure.FeatureFailure

class LoginFailure {
    class CredentialsError : FeatureFailure()
}

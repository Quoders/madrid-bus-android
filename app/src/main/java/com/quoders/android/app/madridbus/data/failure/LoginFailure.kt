package com.quoders.android.app.madridbus.data.failure

import com.quoders.android.app.madridbus.core.functional.Failure.FeatureFailure

class LoginFailure {
    class CredentialsError : FeatureFailure()
}

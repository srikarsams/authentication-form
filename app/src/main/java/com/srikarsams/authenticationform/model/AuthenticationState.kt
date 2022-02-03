package com.srikarsams.authenticationform.model

data class AuthenticationState(
    val authenticationMode: AuthenticationMode = AuthenticationMode.SIGN_IN,
    val email: String? = null,
    val password: String? = null,
    val passwordRequirements: List<PasswordRequirements> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
) {
    fun isFormValid(): Boolean {
        return email?.isNotEmpty() === true &&
                password?.isNotEmpty() === true &&
                (authenticationMode == AuthenticationMode.SIGN_IN || passwordRequirements.containsAll(
                    PasswordRequirements.values().toList()
                ))
    }
}
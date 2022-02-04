package com.srikarsams.authenticationform.ui.theme

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.srikarsams.authenticationform.model.AuthenticationEvent
import com.srikarsams.authenticationform.model.AuthenticationState
import com.srikarsams.authenticationform.model.AuthenticationViewModel

@ExperimentalAnimationApi
@Composable
fun Authentication() {
    val viewModel: AuthenticationViewModel = viewModel()
    val uiState: AuthenticationState = viewModel.uiState.collectAsState().value
    MaterialTheme {
        AuthenticationContent(
            modifier = Modifier.fillMaxSize(),
            authenticationState = uiState,
            handleEvent = viewModel::handleEvent
        )
    }
}

@ExperimentalAnimationApi
@Composable
fun AuthenticationContent(
    modifier: Modifier = Modifier,
    authenticationState: AuthenticationState,
    handleEvent: (AuthenticationEvent) -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        if (authenticationState.isLoading) {
            CircularProgressIndicator()
        } else {
            AuthenticationForm(
                authenticationMode = authenticationState.authenticationMode,
                email = authenticationState.email,
                onEmailChanged = { email ->
                    handleEvent(AuthenticationEvent.EmailChanged(email))
                },
                password = authenticationState.password,
                onPasswordChanged = {
                    handleEvent(AuthenticationEvent.PasswordChanged(it))
                },
                onAuthenticate = {
                    handleEvent(AuthenticationEvent.Authenticate)
                },
                satisfiedRequirements = authenticationState.passwordRequirements,
                enableAuthentication = authenticationState.isFormValid(),
                toggleAuthentication = {
                    handleEvent(AuthenticationEvent.ToggleAuthenticationMode)
                }
            )
            authenticationState.error?.let { error ->
                AuthenticationErrorDialog(error = error) {
                    handleEvent(AuthenticationEvent.ErrorDismissed)
                }
            }
        }
    }
}
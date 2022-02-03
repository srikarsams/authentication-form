package com.srikarsams.authenticationform.ui.theme

import android.widget.Space
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import com.srikarsams.authenticationform.model.AuthenticationMode
import com.srikarsams.authenticationform.model.PasswordRequirements

@ExperimentalAnimationApi
@Composable
fun AuthenticationForm(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    email: String?,
    onEmailChanged: (email: String) -> Unit,
    password: String?,
    onPasswordChanged: (password: String) -> Unit,
    onAuthenticate: () -> Unit,
    satisfiedRequirements: List<PasswordRequirements>,
    enableAuthentication: Boolean,
    toggleAuthentication: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        AuthenticationTitle(authenticationMode = authenticationMode)
        Spacer(modifier = Modifier.height(40.dp))
        val passwordFocusRequester = FocusRequester()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                EmailInput(
                    email = email,
                    onEmailChanged = onEmailChanged,
                    modifier = Modifier.fillMaxWidth(),
                    onNextClicked = {
                        passwordFocusRequester.requestFocus()
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                PasswordInput(
                    password = password,
                    onPasswordChanged = onPasswordChanged,
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(passwordFocusRequester),
                    onDoneClicked = {
                        onAuthenticate()
                    }
                )
                Spacer(modifier = Modifier.height(12.dp))
                AnimatedVisibility(visible = AuthenticationMode.SIGN_UP === authenticationMode) {
                    PasswordRequirements(satisfiedRequirements = satisfiedRequirements)
                }
                Spacer(modifier = Modifier.height(12.dp))
                AuthenticationButton(
                    authenticationMode = authenticationMode,
                    onButtonClick = { onAuthenticate() },
                    enableAuthentication = enableAuthentication
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        ToggleAuthenticationMode(authenticationMode = authenticationMode) {
            toggleAuthentication()
        }
    }
}
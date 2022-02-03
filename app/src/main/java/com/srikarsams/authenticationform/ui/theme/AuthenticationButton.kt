package com.srikarsams.authenticationform.ui.theme

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.srikarsams.authenticationform.R
import com.srikarsams.authenticationform.model.AuthenticationMode

@Composable
fun AuthenticationButton(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    onButtonClick: () -> Unit,
    enableAuthentication: Boolean
) {
    Button(
        onClick = {
            onButtonClick()
        },
        modifier = modifier,
        enabled = enableAuthentication
    ) {
        Text(
            text = if (authenticationMode == AuthenticationMode.SIGN_UP) {
                stringResource(id = R.string.action_sign_up)
            } else {
                stringResource(id = R.string.action_sign_in)
            }
        )
    }
}
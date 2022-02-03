package com.srikarsams.authenticationform.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.srikarsams.authenticationform.R
import com.srikarsams.authenticationform.model.AuthenticationMode

@Composable
fun ToggleAuthenticationMode(
    modifier: Modifier = Modifier,
    authenticationMode: AuthenticationMode,
    toggleAuthentication: () -> Unit
) {
    Surface(
        modifier = modifier.padding(top = 16.dp)
    ) {
        TextButton(
            onClick = {
                toggleAuthentication()
            },
            modifier = Modifier
                .background(MaterialTheme.colors.surface)
                .padding(8.dp),
        ) {
            Text(
                text = stringResource(
                    id = if (authenticationMode == AuthenticationMode.SIGN_UP) {
                        R.string.action_already_have_account
                    } else {
                        R.string.action_need_account
                    }
                )
            )
        }
    }
}
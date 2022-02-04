package com.srikarsams.authenticationform.ui.theme

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.srikarsams.authenticationform.R

@Composable
fun AuthenticationErrorDialog(
    modifier: Modifier = Modifier,
    error: String,
    dismissError: () -> Unit
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            dismissError()
        },
        confirmButton = {
            TextButton(onClick = {
                dismissError()
            }) {
                Text(text = stringResource(id = R.string.error_action))
            }
        },
        title = {
            Text(text = stringResource(id = R.string.error_title), fontSize = 18.sp)
        },
        text = {
            Text(text = error)
        }
    )
}
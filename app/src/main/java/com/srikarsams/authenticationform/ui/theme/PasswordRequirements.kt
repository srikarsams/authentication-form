package com.srikarsams.authenticationform.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.srikarsams.authenticationform.model.PasswordRequirements

@Composable
fun PasswordRequirements(
    modifier: Modifier = Modifier,
    satisfiedRequirements: List<PasswordRequirements>
) {
    Column(modifier = modifier) {
        PasswordRequirements.values().forEach {
            Requirement(
                message = stringResource(id = it.label),
                isSatisfied = satisfiedRequirements.contains(it)
            )
        }
    }
}
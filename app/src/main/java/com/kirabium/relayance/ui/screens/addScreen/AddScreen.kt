package com.kirabium.relayance.ui.screens.addScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.kirabium.relayance.R
import com.oliviermarteaux.localShared.composables.SharedScaffold
import com.oliviermarteaux.shared.composables.SharedOutlinedTextField
import com.oliviermarteaux.shared.ui.theme.SharedPadding

@Composable
fun AddScreen(
    addViewModel: AddViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    SharedScaffold(
        title = stringResource(R.string.app_name),
        topAppBarModifier = Modifier.shadow(4.dp), // adds elevation shadow
        onBackClick = navigateBack,
        onFabClick = {}
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(SharedPadding.xl)
        ) {
            SharedOutlinedTextField(
                value = "",
                onValueChange = {},
                label = stringResource(R.string.name),
            )
            SharedOutlinedTextField(
                value = "",
                onValueChange = {},
                label = stringResource(R.string.email),
            )
        }
    }
}
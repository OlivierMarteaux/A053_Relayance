package com.kirabium.relayance.ui.screens.addScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.kirabium.relayance.R
import com.kirabium.relayance.ui.navigation.SharedViewModel
import com.oliviermarteaux.localShared.composables.SharedScaffold
import com.oliviermarteaux.shared.composables.SharedOutlinedTextField
import com.oliviermarteaux.shared.extensions.isValidEmail
import com.oliviermarteaux.shared.ui.theme.SharedPadding

@Composable
fun AddScreen(
    addViewModel: AddViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel,
    navigateBack: () -> Unit
) {
    with(sharedViewModel){
        with(addViewModel) {
            SharedScaffold(
                title = stringResource(R.string.app_name),
                topAppBarModifier = Modifier.shadow(4.dp), // adds elevation shadow
                onBackClick = navigateBack,
                onFabClick = {
                    addCustomer{setNewCustomerCreated(); navigateBack()}
                },
                fabContentDescription = "Save the new customer"
            ) { innerPadding ->
                AddBody(
                    name = name,
                    email = email,
                    onNameChange = ::onNameChange,
                    onEmailChange = ::onEmailChange,
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(SharedPadding.xl)
                        .fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun AddBody(
    name: String,
    email: String,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        SharedOutlinedTextField(
            value = name,
            onValueChange = {onNameChange(it)},
            label = stringResource(R.string.name),
            isError = name.isEmpty(),
            errorText = stringResource(R.string.add_screen_name_error_empty),
            modifier = Modifier.fillMaxWidth()
        )
        SharedOutlinedTextField(
            value = email,
            onValueChange = {onEmailChange(it)},
            label = stringResource(R.string.email),
            isError = email.run { isEmpty() || !isValidEmail() },
            errorText = if (email.isEmpty()) stringResource(R.string.add_screen_email_error_empty)
            else stringResource(R.string.add_screen_email_error_invalid),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
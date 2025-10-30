package com.kirabium.relayance.ui.screens.homeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.oliviermarteaux.localShared.composables.SharedScaffold
import com.kirabium.relayance.R
import com.kirabium.relayance.data.service.DummyData
import com.kirabium.relayance.data.service.DummyData.customers
import com.kirabium.relayance.domain.model.Customer
import com.oliviermarteaux.shared.composables.texts.TextBodyLarge
import com.oliviermarteaux.shared.composables.texts.TextBodySmall
import com.oliviermarteaux.shared.ui.theme.SharedPadding
import com.oliviermarteaux.shared.utils.AndroidLogger
import com.oliviermarteaux.shared.utils.Logger

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    navigateToDetailScreen: (Int) -> Unit,
    navigateToAddScreen: () -> Unit
    ) {
    SharedScaffold(
        title = stringResource(R.string.app_name),
        topAppBarModifier = Modifier.shadow(4.dp), // adds elevation shadow
        onFabClick = navigateToAddScreen
    ){ innerPadding ->
        with(homeViewModel) {
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(SharedPadding.xl)
            ) {
                items(customers) {
                    Column(
                        modifier = Modifier
                            .padding(bottom = SharedPadding.xl)
                            .clickable { navigateToDetailScreen(it.id)}
                    ) {
                        TextBodyLarge(text = it.name)
                        TextBodySmall(it.email)
                    }
                }
            }
        }
    }
}
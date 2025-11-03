package com.kirabium.relayance.ui.screens.homeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.kirabium.relayance.R
import com.kirabium.relayance.data.service.DummyData.customers
import com.kirabium.relayance.domain.model.Customer
import com.kirabium.relayance.ui.navigation.SharedViewModel
import com.oliviermarteaux.localShared.composables.SharedScaffold
import com.oliviermarteaux.shared.composables.SharedToast
import com.oliviermarteaux.shared.composables.texts.TextBodyLarge
import com.oliviermarteaux.shared.composables.texts.TextBodySmall
import com.oliviermarteaux.shared.ui.theme.SharedPadding

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel,
    navigateToDetailScreen: (Int) -> Unit,
    navigateToAddScreen: (Int) -> Unit
    ) {
    SharedScaffold(
        title = stringResource(R.string.app_name),
        topAppBarModifier = Modifier.shadow(4.dp), // adds elevation shadow
        onFabClick = { navigateToAddScreen(customers.size + 1) }
    ){ innerPadding ->
        with(sharedViewModel) {
            with(homeViewModel) {
                Box(){
                    HomeBody(
                        customers = customers,
                        navigateToDetailScreen = navigateToDetailScreen,
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(SharedPadding.xl)
                    )
                    if (newCustomerCreated) SharedToast("New customer succesfully created")
                }
            }
        }
    }
}

@Composable
fun HomeBody(
    customers: List<Customer>,
    navigateToDetailScreen: (Int) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier
    ) {
        items(customers) {
            Column(
                modifier = Modifier
                    .padding(bottom = SharedPadding.xl)
                    .clickable { navigateToDetailScreen(it.id) }
            ) {
                TextBodyLarge(text = it.name)
                TextBodySmall(it.email)
            }
        }
    }
}
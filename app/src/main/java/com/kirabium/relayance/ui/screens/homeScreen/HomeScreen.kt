package com.kirabium.relayance.ui.screens.homeScreen

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
import com.oliviermarteaux.localShared.composables.SharedScaffold
import com.kirabium.relayance.R
import com.kirabium.relayance.data.service.DummyData
import com.oliviermarteaux.shared.composables.texts.TextBodyLarge
import com.oliviermarteaux.shared.composables.texts.TextBodySmall
import com.oliviermarteaux.shared.ui.theme.SharedPadding
import com.oliviermarteaux.shared.utils.AndroidLogger
import com.oliviermarteaux.shared.utils.Logger

@Composable
fun HomeScreen() {
    SharedScaffold(
        title = stringResource(R.string.app_name),
        topAppBarModifier = Modifier.shadow(4.dp), // adds elevation shadow
        onFabClick = {}
    ){ innerPadding ->
        val customers = DummyData.customers
        val log: Logger = AndroidLogger
        log.d("customers count: ${customers.size}")
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(SharedPadding.xl)
        ){
            items(customers){
                Column(modifier = Modifier.padding(bottom = SharedPadding.xl)){
                    TextBodyLarge(text = it.name)
                    TextBodySmall(it.email)
                }
            }
        }
    }
}
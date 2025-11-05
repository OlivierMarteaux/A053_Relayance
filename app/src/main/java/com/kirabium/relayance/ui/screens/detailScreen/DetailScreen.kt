package com.kirabium.relayance.ui.screens.detailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.kirabium.relayance.R
import com.kirabium.relayance.domain.model.Customer
import com.oliviermarteaux.shared.composables.SharedScaffold
import com.oliviermarteaux.shared.extensions.toHumanDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    detailViewModel: DetailViewModel = hiltViewModel(),
    navigateBack: () -> Unit,
) {
    SharedScaffold(
        title = stringResource(id = R.string.detail_screen_title),
        onBackClick = navigateBack
    ){ contentPadding ->
        DetailBody(
            customer = detailViewModel.customer,
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .background(Color(0xFFF3F3F3))
        )
    }
}

@Composable
fun DetailBody(
    customer: Customer,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Box(modifier = Modifier.padding(24.dp)) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = customer.name,
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = customer.email,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(
                            id = R.string.created_at,
                            customer.createdAt.toHumanDate()
                        ),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp
                        )
                    )
                }
                if (customer.isNewCustomer()) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .offset(x = 24.dp, y = (-24).dp)
                            .rotate(45f)
                            .background(Color.Red)
                            .padding(8.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.new_ribbon),
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
        }
    }
}
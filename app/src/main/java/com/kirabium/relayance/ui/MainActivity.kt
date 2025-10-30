package com.kirabium.relayance.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.kirabium.relayance.data.service.DummyData
import com.kirabium.relayance.databinding.ActivityMainBinding
import com.kirabium.relayance.ui.navigation.RelayanceNavHost

import com.kirabium.relayance.ui.screens.homeScreen.HomeScreen
import com.oliviermarteaux.shared.composables.startup.DismissKeyboardOnTapOutside
import com.oliviermarteaux.shared.composables.startup.RequestNotificationPermission
import com.oliviermarteaux.shared.firebase.firebaseCloudMessaging.getDeviceToken
import com.openclassrooms.hexagonal.games.ui.theme.RelayanceTheme

//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityMainBinding
//    private lateinit var customerAdapter: CustomerAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setupBinding()
//        setupCustomerRecyclerView()
//        setupFab()
//    }
//
//    private fun setupFab() {
//        binding.addCustomerFab.setOnClickListener {
//            val intent = Intent(this, AddCustomerActivity::class.java)
//            startActivity(intent)
//        }
//    }
//
//    private fun setupCustomerRecyclerView() {
//        binding.customerRecyclerView.layoutManager = LinearLayoutManager(this)
//        customerAdapter = CustomerAdapter(DummyData.customers) { customer ->
//            val intent = Intent(this, DetailActivity::class.java).apply {
//                putExtra(DetailActivity.Companion.EXTRA_CUSTOMER_ID, customer.id)
//            }
//            startActivity(intent)
//        }
//        binding.customerRecyclerView.adapter = customerAdapter
//    }
//
//    private fun setupBinding() {
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//    }
//}

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
//
//            // Observe current backstack entry
//            val currentBackStackEntry by navController.currentBackStackEntryAsState()
//            LaunchedEffect(currentBackStackEntry) {
//                currentBackStackEntry?.destination?.route?.let { route ->
//                    Log.i("OM_TAG", " ${route.uppercase()} SCREEN")
//                }
//            }
            RelayanceTheme {
//        SetStatusBarColor(Color.Transparent)
//                RequestNotificationPermission()
//                getDeviceToken()
                RelayanceNavHost(navHostController = navController)
//                DismissKeyboardOnTapOutside { HomeScreen() }
            }
        }
    }
}
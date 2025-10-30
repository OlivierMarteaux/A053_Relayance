package com.kirabium.relayance.ui

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


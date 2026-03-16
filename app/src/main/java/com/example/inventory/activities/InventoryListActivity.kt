package com.example.inventory.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.inventory.R
import com.example.inventory.network.RetrofitClient
import kotlinx.coroutines.*

class InventoryListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory_list)

        val tv = findViewById<TextView>(R.id.tvInventory)

        CoroutineScope(Dispatchers.IO).launch {

            val list = RetrofitClient.api.getInventory()

            withContext(Dispatchers.Main) {

                val builder = StringBuilder()

                for (item in list) {
                    builder.append(item.productName + " | Qty: " + item.quantity + " | Exp: " + item.expiryDate + "\n\n")
                }

                tv.text = builder.toString()
            }
        }
    }
}
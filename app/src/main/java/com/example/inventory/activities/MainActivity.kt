package com.example.inventory.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.inventory.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnScan).setOnClickListener {
            startActivity(Intent(this, AddProductActivity::class.java))
        }

        findViewById<Button>(R.id.btnInventory).setOnClickListener {
            startActivity(Intent(this, InventoryListActivity::class.java))
        }
    }
}
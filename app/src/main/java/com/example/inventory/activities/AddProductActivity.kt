package com.example.inventory.activities

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.inventory.R
import com.example.inventory.data.InventoryItem
import com.example.inventory.network.RetrofitClient
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import kotlinx.coroutines.*

class AddProductActivity : AppCompatActivity() {

    private lateinit var etBarcode: EditText
    private lateinit var etName: EditText
    private lateinit var etQty: EditText
    private lateinit var etDate: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        etBarcode = findViewById(R.id.etBarcode)
        etName = findViewById(R.id.etName)
        etQty = findViewById(R.id.etQty)
        etDate = findViewById(R.id.etDate)

        findViewById<Button>(R.id.btnStartScan).setOnClickListener {
            barcodeLauncher.launch(ScanOptions())
        }

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            saveData()
        }
    }

    private val barcodeLauncher = registerForActivityResult(ScanContract()) { result ->
        if (result.contents != null) {
            etBarcode.setText(result.contents)
        }
    }

    private fun saveData() {

        val item = InventoryItem(
            id = System.currentTimeMillis().toString(),
            productName = etName.text.toString(),
            barcode = etBarcode.text.toString(),
            quantity = etQty.text.toString().toInt(),
            expiryDate = etDate.text.toString()
        )

        CoroutineScope(Dispatchers.IO).launch {
            try {
                RetrofitClient.api.addItem(item)
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@AddProductActivity,"Saved",Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@AddProductActivity,e.message,Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
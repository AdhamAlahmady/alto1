package com.example.inventory.network

import com.example.inventory.data.InventoryItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiService {

    @GET("")
    suspend fun getInventory(): List<InventoryItem>

    @POST("")
    suspend fun addItem(@Body item: InventoryItem): retrofit2.Response<Unit>
}

object RetrofitClient {

    private const val BASE_URL = "https://script.google.com/macros/s/AKfycbyyRIneritxay6VHZtLLrmY9RxaGDS8oVMYHjJ20adZobHBdqAu3vsv7Ss1RcyRNjqCdw/exec/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
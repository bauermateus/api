package com.mbs.api_recycler

import UserModel
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mbs.api_recycler.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ApiAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        adapter = ApiAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val call = RetrofitService.api.list()

        call.enqueue(object : Callback<UserModel> {
            override fun onResponse(
                call: Call<UserModel>, response: Response<UserModel>,
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { adapter.updateUsers(it) }
                }
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                t.message?.let { Log.e("erro", it) }
            }
        })
    }

}

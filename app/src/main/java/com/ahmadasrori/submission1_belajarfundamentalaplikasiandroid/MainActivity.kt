package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val listUser = ArrayList<UserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initData()
        initList()
    }

    private fun initData() {
        val jsonFileString = getJsonDataFromAsset(this, "githubuser.json")
        val obj = Gson().fromJson(jsonFileString, UserDataResponse::class.java)
        for (i in obj.list?.indices!!) {
            listUser.add(obj.list!![i])
        }
    }

    private fun initList() {
        val adapter = UserAdapter(this, listUser) {
            val intent = Intent(this@MainActivity, UserDetailActivity::class.java)
            intent.putExtra(UserDetailActivity.EXTRA_PERSON, listUser[it])
            startActivity(intent)
        }
        binding.rvItem.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvItem.adapter = adapter
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}
package com.example.utspemob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import android.content.Intent
//import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvTempatWisata: RecyclerView
    private val list = ArrayList<TempatWisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvTempatWisata = findViewById(R.id.rv_tempatwisata)
        rvTempatWisata.setHasFixedSize(true)
        list.addAll(getListTempatWIsata())
        showRecyclerList()
    }

    private fun getListTempatWIsata(): ArrayList<TempatWisata> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription =
            resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listTempatWisata = ArrayList<TempatWisata>()
        for (i in dataName.indices) {
            val tempatwisata = TempatWisata(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listTempatWisata.add(tempatwisata)
        }
        return listTempatWisata
    }

    private fun showRecyclerList() {
        rvTempatWisata.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListTempatWisataAdapter(list)
        rvTempatWisata.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object :
            ListTempatWisataAdapter.OnItemClickCallback {
            override fun onItemClicked(data: TempatWisata) {
                showSelectedTempatWisata(data)
            }
        })
    }

    private fun showSelectedTempatWisata(tempatwisata: TempatWisata) {
        Toast.makeText(this, "Kamu memilih " + tempatwisata.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_profile -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

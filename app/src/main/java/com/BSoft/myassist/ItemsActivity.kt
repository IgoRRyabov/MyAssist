package com.BSoft.myassist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_items)

        val itemsList : RecyclerView = findViewById(R.id.Items)
        val items = arrayListOf<Item>()

        items.add(Item(1, "home", "Дом", "Небольшой дом", "Продажа дома на участке с озером", 100))
        items.add(Item(2, "airplane", "Самолет", "Продается кукурузник", "Год производства 1997. Часов в полете 2700ч", 700))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}
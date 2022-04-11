package com.example.dbmsui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.dbmsui.adapters.Adapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val name = "User" // get name from firebase
        toolbar.title = "Hello, $name 👋"
        setSupportActionBar(toolbar as Toolbar)

        val list1 = arrayListOf<String>(
            "Category related to topic 1",
            "Category related to topic 5",
            "Category related to topic 42",
            "Category related to topic 69",
            "Category related to topic 2",
            "Category related to topic 3"
        )
        val adapter1 = Adapter(list1, this)
        findViewById<Spinner>(R.id.spinner_category).adapter = adapter1

        val list2 = arrayListOf<String>("Male", "Female", "Other", "View for all")
        val adapter2 = Adapter(list2, this)
        findViewById<Spinner>(R.id.spinner_gender).adapter = adapter2

        val list3 = arrayListOf<String>("< 50,000", "50,000 - 1,00,000", "1,00,000 - 5,00,000", "5,00,000 - 10,00,000","> 10,00,000","Rather not say")
        val adapter3 = Adapter(list3, this)
        findViewById<Spinner>(R.id.spinner_salary).adapter = adapter3


    }

    // Inflating menu to Toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            // Code to performed when menuItem clicked
            R.id.i2 ->{
                startActivity(Intent(this, LoginActivity::class.java))
                overridePendingTransition(
                    androidx.appcompat.R.anim.abc_fade_in,
                    androidx.appcompat.R.anim.abc_fade_out
                )
            }
        }
        return true
    }
}

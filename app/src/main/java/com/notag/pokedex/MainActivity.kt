package com.notag.pokedex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timer(false).schedule(2000) {
            val intentHome: Intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intentHome)
            finish()
        }
    }
}
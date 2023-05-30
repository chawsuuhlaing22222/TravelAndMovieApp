package com.codico.movieandtravelapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codico.movieandtravelapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setUpListener()


    }

    private fun setUpListener() {
        btnCreateNewAcctount.setOnClickListener {
            startActivity(Intent(this,CreateNewAccountActivity::class.java))
        }

    }
}
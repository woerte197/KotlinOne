package com.example.wangyang.mykotlin

import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showNoDataBg()
    }

    private fun showNoDataBg() {
        noData.visibility = View.VISIBLE
    }


}

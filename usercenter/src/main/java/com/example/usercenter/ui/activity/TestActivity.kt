package com.example.usercenter.ui.activity

import android.os.Bundle
import org.jetbrains.anko.*

class TestActivity : RegisterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            padding = 30
            editText {
                hint = "Name"
                textSize = 24f
            }
            editText {
                hint = "Password"
                textSize = 24f
            }
            button {
                text = "登录"
                textSize = dip(18).toFloat()
            }
        }
        toast("${intent.getIntExtra("id", -1)}")
    }

}

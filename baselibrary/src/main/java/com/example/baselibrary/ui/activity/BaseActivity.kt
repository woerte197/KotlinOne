package com.example.baselibrary.ui.activity

import android.os.Bundle
import com.example.baselibrary.common.AppManager
import com.trello.rxlifecycle2.components.RxActivity
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import org.jetbrains.anko.toast

open class BaseActivity : RxAppCompatActivity() {

    private var pressTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }

    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            toast("再次点击返回退出应用")
            pressTime = System.currentTimeMillis()
        } else {
            AppManager.instance.exitApp(this)
        }

    }
}
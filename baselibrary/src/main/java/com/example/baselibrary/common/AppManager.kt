package com.example.baselibrary.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

class AppManager private constructor() {
    private val activityStack: Stack<Activity> = Stack()

    companion object {
        val instance: AppManager by lazy { AppManager() }
    }

    /*
    * 入栈
    * */
    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }

    /*
    * 出栈
    * */
    fun finishActivity(activity: Activity) {
        activity.finish()
        activityStack.remove(activity)
    }

    fun getIns(): AppManager {
        return instance
    }

    /*
    * 获取栈顶Activity
    * */
    fun getStackTopActivity(): Activity {
        return activityStack.lastElement()
    }

    /*
    * 清空栈
    * */
    private fun clearAllActivity() {
        for (activity in activityStack) {
            activity.finish()
        }
        activityStack.clear()
    }

    /*
    * 退出应用程序
    * */
    fun exitApp(context: Context) {
        clearAllActivity()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }

}
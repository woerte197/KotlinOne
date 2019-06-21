package com.example.usercenter.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.example.baselibrary.ui.activity.BaseActivity
import com.example.usercenter.R
import com.example.usercenter.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {
    private val stack = Stack<Fragment>()
    private val mHomeFragment by lazy { HomeFragment() }
    private val mCategoryFragment by lazy { HomeFragment() }
    private val mCartFragment by lazy { HomeFragment() }
    private val mMsgFragment by lazy { HomeFragment() }
    private val mUserFragment by lazy { HomeFragment() }
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavBar.checkCartBadge(10)
        bottomNavBar.checkMsgBadge(false)
        initFragment()
        initEvent()
        changeFragment(0)
    }

    private fun initFragment() {
        val transaction = supportFragmentManager.beginTransaction();
        transaction.add(R.id.mContaier, mHomeFragment)
        transaction.add(R.id.mContaier, mCategoryFragment)
        transaction.add(R.id.mContaier, mCartFragment)
        transaction.add(R.id.mContaier, mMsgFragment)
        transaction.add(R.id.mContaier, mUserFragment)
        transaction.commit()
        stack.add(mHomeFragment)
        stack.add(mCategoryFragment)
        stack.add(mCartFragment)
        stack.add(mMsgFragment)
        stack.add(mUserFragment)
    }

    private fun initEvent() {
        bottomNavBar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabReselected(position: Int) {

            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)
            }
        })
    }

    private fun changeFragment(position: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        for (fragment in stack) {
            transaction.hide(fragment)
        }
        transaction.show(stack[position])
    }


}

package com.example.usercenter.ui.fragment

import android.os.Bundle
import com.example.baselibrary.banner.GlideImageLoader
import com.example.baselibrary.widgets.NewsFlipperView
import com.example.usercenter.R
import com.example.usercenter.presenter.HomePresenter
import com.kotlin.base.ui.fragment.BaseMvpFragment
import com.youth.banner.Banner
import org.jetbrains.anko.find
class HomeFragment : BaseMvpFragment<HomePresenter>() {
    override fun injectComponent() {

    }

    override fun setLayout(): Int {
        return R.layout.fragment_home
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    private fun initView() {
        val testString: MutableList<String> = ArrayList()
        testString.add("在很多人还没用上Android 8.0正式版的当下，谷歌就已经正式推出了Android P的开发者预览版。")
        testString.add("这个下一版本的Android操作系统将会在今年Google I/O大会上正式发布，不过在预览版之中，我们就已经能够提前体验到即将到来的新特性啦。")
        view?.find<NewsFlipperView>(R.id.mNewsFlipperView)?.setData(testString)
        val mImagePaths: MutableList<String> = ArrayList()
        mImagePaths.add("http://image.baidu.com/search/detail?ct=503316480&z=0&tn=baiduimagedetail&ipn=d&word=tupian&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=-1&hd=undefined&latest=undefined&copyright=undefined&cs=3300305952,1328708913&os=188573792,343995474&simid=4174703319,828922280&pn=0&rn=1&di=179080&ln=1624&fr=&fmq=1561109956613_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=2&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fpic37.nipic.com%2F20140113%2F8800276_184927469000_2.png&rpstart=0&rpnum=0&adpicid=0&force=undefined")
        mImagePaths.add("http://image.baidu.com/search/detail?ct=503316480&z=0&tn=baiduimagedetail&ipn=d&word=tupian&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=-1&hd=undefined&latest=undefined&copyright=undefined&cs=1688631197,3554659657&os=573597838,2991187519&simid=3454739488,446162139&pn=1&rn=1&di=110550&ln=1624&fr=&fmq=1561109956613_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=2&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fpic.58pic.com%2F58pic%2F13%2F82%2F74%2F92q58PICeSI_1024.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined")

        view?.find<Banner>(R.id.mBanner)!!.setImageLoader(GlideImageLoader())
        view?.find<Banner>(R.id.mBanner)!!.setImages(mImagePaths)
        view?.find<Banner>(R.id.mBanner)!!.start()
    }
}
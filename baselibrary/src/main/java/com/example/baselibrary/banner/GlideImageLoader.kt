package com.example.baselibrary.banner

import android.content.Context
import android.widget.ImageView
import com.kotlin.base.utils.GlideUtil
import com.youth.banner.loader.ImageLoader

class GlideImageLoader : ImageLoader() {
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        GlideUtil.loadImage(context!!, path as String, imageView!!)
    }
}
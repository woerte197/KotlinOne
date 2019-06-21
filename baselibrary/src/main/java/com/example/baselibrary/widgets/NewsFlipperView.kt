package com.example.baselibrary.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.ViewFlipper
import com.example.baselibrary.R
import org.jetbrains.anko.find
import org.jetbrains.anko.imageResource

class NewsFlipperView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var data: List<String>? = null
    private val viewFlipperView: ViewFlipper
    private var imageView: ImageView

    init {
        val view = View.inflate(context, R.layout.item_news_flipper, this)
        viewFlipperView = view.find(R.id.mViewFlipper)
        viewFlipperView.setInAnimation(context, R.anim.anim_news_letter_in)
        viewFlipperView.setOutAnimation(context, R.anim.anim_news_letter_out)
        imageView = view.find(R.id.mImageView)
    }

//    fun createNewsFlipperView() {
//        val data = this.data ?: throw NullPointerException("Please Set Data!")
//        val size = data.size
//        for (i in 0 until size) {
//            val textView = View.inflate(context, R.layout.item_news_layout, null)
//            textView.findViewById<TextView>(R.id.mNewsText).text = data[i]
//            viewFlipperView.addView(textView)
//        }
//    }

    private fun crateView(text: String): View {
        val view = View.inflate(context, R.layout.item_news_layout, null)
        view.findViewById<TextView>(R.id.mNewsText).text = text
        return view
    }

    fun setData(data: List<String>) {
         this.data = data
         for (text in data) {
             viewFlipperView.addView(crateView(text))
         }
     }

    fun setImageViewRes(resource: Int) {
        imageView.imageResource = resource
    }

}
package com.example.touchevent

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.children

class MyCustomIndicater: ViewGroup{
    //代码中创建这个控件时，会调用这个构造函数
    constructor(context: Context):super(context){
    }
    //xml中拖拽控件就会调用这个构造函数，并且把控件的所有属性封装为AttributeSet类型
    constructor(context: Context, attrs: AttributeSet?):super(context,attrs){
    }
    //xml 使用style资源id
    constructor(context: Context, attrs: AttributeSet?, style:Int):super(context,attrs,style){
    }

    //在这个方法里面 容器的尺寸就确定了
    //1.获取容器的宽 高
    //2.添加子控件
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        val view = ImageView(context).apply {
            setImageResource(R.drawable.bg)
            visibility = INVISIBLE
        }
        addView(view)
    }

    //子控件如何布局 如何显示 宽度 高度  x  y
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        //查找自己的子控件 0..9
        val iv = getChildAt(0)
        //布局
        iv.layout(dp2px(20),dp2px(20),dp2px(200),dp2px(200)) //180 180 / 3 = 6
    }
    fun dp2px(dp:Int) = (resources.displayMetrics.density*dp).toInt()

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN){
            val iv = getChildAt(0) as ImageView
            iv.visibility = VISIBLE
            //iv.setImageResource(R.drawable.calculate)
        }
        return true
    }

}
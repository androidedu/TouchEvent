package com.example.touchevent

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class MyUnlockView: View {
    //代码中创建这个控件时，会调用这个构造函数
    constructor(context: Context):super(context){
        initUI()
    }
    //xml中拖拽控件就会调用这个构造函数，并且把控件的所有属性封装为AttributeSet类型
    constructor(context: Context, attrs:AttributeSet?):super(context,attrs){
        initUI()
    }

    //xml 使用style资源id
    constructor(context: Context, attrs:AttributeSet?, style:Int):super(context,attrs,style){
        initUI()
    }

    //初始化方法
    fun initUI(){
        setBackgroundColor(Color.MAGENTA)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.v("pxd","un lock view")
        setBackgroundColor(Color.BLACK)
        return true
    }
}
package com.example.touchevent

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Point
import android.graphics.PointF
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    var barHeight = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1.获取需要单独处理触摸事件的view
        val view = findViewById<View>(R.id.unlockView)
        view.setOnTouchListener{ _, event ->
            if (event.action == MotionEvent.ACTION_DOWN){
                view.setBackgroundColor(Color.BLACK)
            }
            true
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.v("pxd","activity on Touch Event")
//        //获取事件类型 ACTION_DOWN = 0
//        when(event?.action){
//            MotionEvent.ACTION_DOWN -> dealWithTouchPoint(event.x,event.y)
//            MotionEvent.ACTION_MOVE -> dealWithTouchPoint(event.x,event.y)
//            MotionEvent.ACTION_UP -> {}
//        }
        return true
    }

    fun dealWithTouchPoint(x:Float, y:Float){
        //获取view的矩形区域 x,y,w,h
        val view = findViewById<View>(R.id.view)
        val viewRect = Rect(
            view.x.toInt(),
            view.y.toInt(),
            (view.x+view.width).toInt(),
            (view.y+view.height).toInt(),
        )

        //判断触摸点 是否在矩形区域内
        if (viewRect.contains(x.toInt(),(y-barHeight).toInt())){
            view.setBackgroundColor(Color.BLACK)
        }
    }

    fun calculateBarHeight(){
        //获取xml中对应容器和控件
        val container = findViewById<ConstraintLayout>(R.id.root)
        container.viewTreeObserver.addOnPreDrawListener{
            //获取测量的高度
            val containerHeight = container.measuredHeight
            //bar的高度 = 屏幕高度 - 容器的高度
            val screenHeight = resources.displayMetrics.heightPixels
            //status bar height
            val resid = resources.getIdentifier(
                "status_bar_height",
                "dimen",
                "android"
            )
            val statusBarHeight = resources.getDimensionPixelSize(resid)
            barHeight = screenHeight - containerHeight + statusBarHeight
            true //继续绘制过程  false 取消当前绘制
        }
    }
}
















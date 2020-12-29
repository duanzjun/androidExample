package com.android.layout

import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import kotlinx.android.synthetic.main.activity_surface_view.*

class SurfaceViewActivity : AppCompatActivity(), SurfaceHolder.Callback {

    private var mSurfaceHolder: SurfaceHolder? = null
    private var mCanvas: Canvas? = null
    private var mIsDrawing: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surface_view)


        initView()

        btnRun.setOnClickListener {
            run()
        }
    }

    private fun initView() {

//        svSurfaceTest.focusable =
        svSurfaceTest.keepScreenOn = true
        svSurfaceTest.isFocusableInTouchMode = true
        svSurfaceTest.holder.addCallback(this)




    }


    //    创建
    override fun surfaceCreated(holder: SurfaceHolder) {
        mIsDrawing = true
        Thread { this }.start()
    }

    //    改变
    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }

    //    销毁
    override fun surfaceDestroyed(holder: SurfaceHolder) {
        mIsDrawing = false

    }

    //    运行
    fun run() {
        while (mIsDrawing) {
            drawSomething()
        }
    }

    private fun drawSomething() {
        try {
            mCanvas = mSurfaceHolder?.lockCanvas()
            mCanvas?.drawColor(Color.WHITE)

        } catch (e: Exception) {

        } finally {
            if (mCanvas != null) {
                mSurfaceHolder?.unlockCanvasAndPost(mCanvas)
            }
        }
    }

    companion object {
        fun actionStart(context: Context) {
            val intent = Intent(context, SurfaceViewActivity::class.java)
            context.startActivity(intent)

        }
    }

}
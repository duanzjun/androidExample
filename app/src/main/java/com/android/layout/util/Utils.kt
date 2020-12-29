package com.android.layout.util

import android.content.Context
import android.graphics.Rect
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowManager


object Utils {
    // 根据手机的分辨率从 dp 的单位 转成为 px(像素)
    fun dip2px(context: Context, dpValue: Float): Int {
        // 获取当前手机的像素密度（1个dp对应几个px）
        val scale: Float = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt() // 四舍五入取整
    }

    // 根据手机的分辨率从 px(像素) 的单位 转成为 dp
    fun px2dip(context: Context, pxValue: Float): Int {
        // 获取当前手机的像素密度（1个dp对应几个px）
        val scale: Float = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt() // 四舍五入取整
    }

    // 获得屏幕的宽度
    fun getScreenWidth(ctx: Context): Int {
        val screenWidth: Int
        // 从系统服务中获取窗口管理器
        val wm = ctx.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        screenWidth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // 获取当前屏幕的四周边界
            val rect: Rect = wm.currentWindowMetrics.bounds
            rect.width()
        } else {
            val dm = DisplayMetrics()
            // 从默认显示器中获取显示参数保存到dm对象中
            wm.defaultDisplay.getMetrics(dm)
            dm.widthPixels
        }
        return screenWidth // 返回屏幕的宽度数值
    }

    // 获得屏幕的高度
    fun getScreenHeight(ctx: Context): Int {
        val screenHeight: Int
        // 从系统服务中获取窗口管理器
        val wm = ctx.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        screenHeight = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // 获取当前屏幕的四周边界
            val rect: Rect = wm.currentWindowMetrics.bounds
            rect.height()
        } else {
            val dm = DisplayMetrics()
            // 从默认显示器中获取显示参数保存到dm对象中
            wm.defaultDisplay.getMetrics(dm)
            dm.heightPixels
        }
        return screenHeight // 返回屏幕的高度数值
    }
}
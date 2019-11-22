package com.bw.baselibrary.utils

import android.content.Context

/**
 *@Author:AbnerMing
 *@Description:
 *@Date:2019/9/20 14:38
 */

class WindowUtils() {
    companion object {

        /**
         * 获取状态栏高度
         *
         * @return
         */
        fun getStatusBarHeight(context: Context): Int {
            var result = 0
            val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
            if (resourceId > 0) {
                result = context.resources.getDimensionPixelSize(resourceId)
            }
            return result
        }

    }
}
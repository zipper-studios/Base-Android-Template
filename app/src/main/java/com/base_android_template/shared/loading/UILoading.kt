package com.base_android_template.shared.loading

import android.content.Context

interface UILoading {
    fun init(context: Context)
    fun show()
    fun hide()
    fun cancel()
}
package com.base_android_template.shared.loading

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.base_android_template.R
import timber.log.Timber

class UILoadingImplementation : UILoading {

    private lateinit var dialog: Dialog

    override fun init(context: Context) {
        buildDialog(context)
    }

    override fun show() {
        try {
            dialog.show()
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    private fun buildDialog(context: Context) {
            dialog = Dialog(context)

            dialog.apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setContentView(R.layout.dialog_loading)
                setCancelable(false)
                window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
    }

    override fun hide() {
        if (!::dialog.isInitialized)
            return

        if (dialog.isShowing) {
            try {
                dialog.hide()
            } catch (e: IllegalStateException) {
                Timber.e(e)
            }
        }
    }

    override fun cancel() {
        if (!::dialog.isInitialized)
            return

        dialog.cancel()
    }
}
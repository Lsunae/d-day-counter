package com.example.presentation.util

import android.os.SystemClock
import android.view.View

class OnSingleClickListener (private var onSingleClick: (View) -> Unit): View.OnClickListener {
    private var mLastClickTime: Long = 0

    override fun onClick(v: View) {
        val currentClickTime: Long = SystemClock.uptimeMillis()
        val elapsedTime = currentClickTime - mLastClickTime
        mLastClickTime = currentClickTime

        if (elapsedTime > MIN_CLICK_INTERVAL) {
            onSingleClick(v)
        }
    }

    companion object {
        private const val MIN_CLICK_INTERVAL: Long = 500
    }
}
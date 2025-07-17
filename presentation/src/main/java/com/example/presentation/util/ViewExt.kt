package com.example.presentation.util

import android.view.View

fun View.setOnSingleClickListener(onSingleClick: (View) -> Unit) =
    setOnClickListener(OnSingleClickListener(onSingleClick))
package com.revan.focuso.util

import android.view.View


fun View.visible () {
    this.visibility = View.VISIBLE
}


fun View.gone() {
    this.visibility = View.GONE
}

fun String.isValidEmail(): Boolean {
    if (this.contains('@') && this.contains('.')) {
        return true
    } else {
        return false
    }
}


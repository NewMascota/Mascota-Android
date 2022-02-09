package org.mascota.core.util.extension

import android.app.Activity
import androidx.annotation.ColorInt

fun Activity.setStatusBarColor(@ColorInt color: Int) {
    this.window?.run { statusBarColor = color }
}

package org.mascota.core.util.extension

import android.app.Activity
import androidx.annotation.ColorInt
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Activity.setStatusBarColor(@ColorInt color: Int) {
    this.window?.run { statusBarColor = color }
}

fun AppCompatActivity.replace(@IdRes frameId: Int, fragment: Fragment) {
    supportFragmentManager
        .beginTransaction()
        .replace(frameId, fragment, null)
        .commit()
}

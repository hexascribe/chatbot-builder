package com.hexascribe.chatbotbuilder.utils

import androidx.compose.ui.graphics.Color
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.value
import platform.CoreGraphics.CGFloatVar
import platform.Foundation.NSString
import platform.Foundation.stringWithFormat
import platform.UIKit.UIColor

internal val String.toColor
    get() = Color(
        this
            .removePrefix("#")
            .toLong(16) or 0x00000000FF000000
    )

@OptIn(ExperimentalForeignApi::class)
internal fun UIColor.toHexString(): String {
    memScoped {
        val red = alloc<CGFloatVar>()
        val green = alloc<CGFloatVar>()
        val blue = alloc<CGFloatVar>()
        val alpha = alloc<CGFloatVar>()
        this@toHexString.getRed(red.ptr, green.ptr, blue.ptr, alpha.ptr)
        val rgb: Int =
            ((red.value * 255).toInt() shl 16) or ((green.value * 255).toInt() shl 8) or (blue.value * 255).toInt()
        return NSString.stringWithFormat("#%06x", rgb)
    }
}

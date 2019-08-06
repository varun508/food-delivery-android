package com.trihkfoods.main.widgets

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.LinearLayout

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
class ItemCounterLayout
@JvmOverloads
constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0,
    defRes: Int = 0
) : LinearLayout(context, attributeSet, defStyle, defRes) {

    init {
        orientation = HORIZONTAL
    }
}
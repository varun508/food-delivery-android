package com.trihkfoods.main.widgets

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.trihkfoods.main.R
import kotlinx.android.synthetic.main.item_counter.view.*

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
class ItemCounterLayout
@JvmOverloads
constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0,
    defRes: Int = 0
) : LinearLayout(context, attributeSet, defStyle, defRes) {

    private var itemCount = 0

    init {
        orientation = HORIZONTAL

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.item_counter, this)

        tvItemCount.text = itemCount.toString()
        background = ContextCompat.getDrawable(
            context,
            R.drawable.curved_rectangle_radius_regular_stroke_regular
        )

        setPadding(
            getPixelValueFromDP(16f).toInt(),
            getPixelValueFromDP(8f).toInt(),
            getPixelValueFromDP(16f).toInt(),
            getPixelValueFromDP(8f).toInt()
        )
    }

    private fun getPixelValueFromDP(value: Float) = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value,
        context.resources.displayMetrics
    )

}
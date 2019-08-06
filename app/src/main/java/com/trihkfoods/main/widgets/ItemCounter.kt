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
import com.trihkfoods.main.utils.onClick
import kotlinx.android.synthetic.main.item_counter.view.*

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
class ItemCounter
@JvmOverloads
constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0,
    defRes: Int = 0
) : LinearLayout(context, attributeSet, defStyle, defRes) {

    private var itemCount = 1
    private val padLeft = getPixelValueFromDP(16f).toInt()
    private val padTop = getPixelValueFromDP(8f).toInt()
    private val padRight = getPixelValueFromDP(16f).toInt()
    private val padBottom = getPixelValueFromDP(8f).toInt()

    private lateinit var onIncrement: (value: Int) -> Unit
    private lateinit var onDecrement: (value: Int) -> Unit

    init {
        orientation = HORIZONTAL

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.item_counter, this)

        background = ContextCompat.getDrawable(
            context,
            R.drawable.curved_rectangle_radius_regular_stroke_regular
        )
        setPadding(padLeft, padTop, padRight, padBottom)

        tvItemCount.text = itemCount.toString()

        ivIncreaseItemCount.onClick {

            onIncrement()
        }
        ivDecreaseItemCount.onClick {
            onDecrement()
        }
    }


    private fun getPixelValueFromDP(value: Float) = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value,
        context.resources.displayMetrics
    )

    fun doOnIncrement(block: (value: Int) -> Unit) {
        if (!::onIncrement.isInitialized) {
            onIncrement = block
        }
    }

    fun doOnDecrement(block: (value: Int) -> Unit) {
        if (!::onDecrement.isInitialized) {
            onDecrement = block
        }
    }

}
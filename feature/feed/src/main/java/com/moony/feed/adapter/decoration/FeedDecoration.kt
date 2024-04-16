package com.moony.feed.adapter.decoration

import android.content.Context
import android.graphics.Rect
import android.util.DisplayMetrics
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class FeedDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        val context = parent.context
        val margin = convertDpToPx(context, 20)

        if(position==0)
            outRect.set(margin,margin,margin,margin)
        else{
            outRect.bottom=margin
            outRect.left=margin
            outRect.right=margin
        }

    }

    private fun convertDpToPx(context: Context, dp: Int): Int =
        (dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
}
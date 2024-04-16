package com.moony.feed.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.moony.feed.databinding.ItemDummyFeedViewHolderBinding
import kotlin.random.Random

class FeedAdapter() : RecyclerView.Adapter<FeedAdapter.ViewHolder>() {

    private val randomColors = arrayOf(Color.BLUE, Color.GREEN, Color.MAGENTA)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(randomColors[Random.nextInt(3)])
    }

    override fun getItemCount(): Int = Random.nextInt(3) + 12

    inner class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        ItemDummyFeedViewHolderBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ).root
    ) {
        private val binding: ItemDummyFeedViewHolderBinding =
            ItemDummyFeedViewHolderBinding.bind(itemView)

        fun bind(@ColorInt color: Int) {
            binding.image.setBackgroundColor(color)
        }
    }
}
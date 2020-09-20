package com.example.appcombatapplication

import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class CaptionedImageAdapter(private val captions: Array<String?>, private val imageIds: Array<Int?>): RecyclerView.Adapter<CaptionedImageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CaptionedImageAdapter.ViewHolder {
        val cardView : CardView = LayoutInflater.from(p0.context).inflate(R.layout.card_captioned_image, p0, false) as CardView
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(p0: CaptionedImageAdapter.ViewHolder, p1: Int) {
        val cardView = p0.cardView
        val imageView = cardView.findViewById(R.id.info_image) as ImageView
        val drawable = imageIds[p1]?.let { ContextCompat.getDrawable(cardView.context, it) }
        imageView.setImageDrawable(drawable)
        imageView.contentDescription = captions[p1]
        val textView = cardView.findViewById(R.id.info_text) as TextView
        textView.text = captions[p1]
    }

    override fun getItemCount() = captions.size

    inner class ViewHolder(val cardView: CardView): RecyclerView.ViewHolder(cardView) {}
}


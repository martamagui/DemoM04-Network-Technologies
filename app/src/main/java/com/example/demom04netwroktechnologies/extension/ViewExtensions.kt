package com.example.demom04netwroktechnologies.extension

import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.imageUrl(imageURl : String){
    Picasso.get().load(imageURl).into(this)
}

fun View.visibleOrGone(visible: Boolean){
    this.visibility = if (visible) View.VISIBLE else View.GONE
}
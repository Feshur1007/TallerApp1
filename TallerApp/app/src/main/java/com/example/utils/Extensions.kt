package com.feshur1007.tallerapp.utils

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.util.Locale

// View helpers
fun View.show() { this.visibility = View.VISIBLE }
fun View.hide() { this.visibility = View.GONE }

// EditText helper para obtener texto limpio
fun EditText.textString(): String = this.text?.toString()?.trim() ?: ""

// Formateo de precios
fun Double.toCurrencyString(): String =
    String.format(Locale.getDefault(), "$%.2f", this)

// Cargar imagen con Glide desde ImageView
fun ImageView.loadUrl(url: String?) {
    if (url.isNullOrEmpty()) {
        this.setImageDrawable(null)
    } else {
        Glide.with(this.context)
            .load(url)
            .into(this)
    }
}
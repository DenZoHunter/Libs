package ru.geekbrains.universe

import android.view.View

fun View.click(click: () -> Unit) = setOnClickListener { click() }
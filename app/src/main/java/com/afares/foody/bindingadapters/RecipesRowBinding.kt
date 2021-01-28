package com.afares.foody.bindingadapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.afares.foody.R

class RecipesRowBinding {

    companion object {

        @BindingAdapter("setNumbersOfLikes")
        @JvmStatic
        fun setNumbersOfLikes(textView: TextView, likes: Int) {
            textView.text = likes.toString()
        }

        @BindingAdapter("setNumbersOfMinutes")
        @JvmStatic
        fun setNumberOfMinutes(textView: TextView, minutes: Int) {
            textView.text = minutes.toString()
        }

        @BindingAdapter("applyVeganColor")
        @JvmStatic
        fun applyVeganColor(view: View, vegan: Boolean) {
            if (vegan) {
                when (view) {
                    is TextView -> {
                        view.setTextColor(
                                ContextCompat.getColor(
                                        view.context,
                                        R.color.green
                                )
                        )
                    }
                    is ImageView -> {
                        view.setColorFilter(
                                ContextCompat.getColor(
                                        view.context,
                                        R.color.green
                                )
                        )
                    }
                }
            }
        }

    }

}
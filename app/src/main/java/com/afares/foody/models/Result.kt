package com.afares.foody.models


import android.os.Parcelable
import com.afares.foody.models.ExtendedIngredient
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    @SerializedName("aggregateLikes")
    val aggregateLikes: Int,
    @SerializedName("cheap")
    val cheap: Boolean,
    @SerializedName("dairyFree")
    val dairyFree: Boolean,
    @SerializedName("extendedIngredients")
    val extendedIngredients: List<ExtendedIngredient>,
    @SerializedName("glutenFree")
    val glutenFree: Boolean,
    @SerializedName("id")
    val recipeId: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("readyInMinutes")
    val readyInMinutes: Int,
    @SerializedName("sourceName")
    val sourceName: String?,
    @SerializedName("sourceUrl")
    val sourceUrl: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("vegan")
    val vegan: Boolean,
    @SerializedName("vegetarian")
    val vegetarian: Boolean,
    @SerializedName("veryHealthy")
    val veryHealthy: Boolean
):Parcelable
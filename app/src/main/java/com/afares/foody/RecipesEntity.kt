package com.afares.foody

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.afares.foody.models.FoodRecipe
import com.afares.foody.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
        var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}
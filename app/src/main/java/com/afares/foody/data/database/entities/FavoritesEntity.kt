package com.afares.foody.data.database.entities

import androidx.room.Entity
import com.afares.foody.models.Result
import com.afares.foody.util.Constants.Companion.FAVORITE_RECIPES_TABLE

@Entity(tableName = FAVORITE_RECIPES_TABLE)
class FavoritesEntity(
    var id: Int,
    var result: Result
)
package com.afares.foody.viewmodels

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.afares.foody.data.DataStoreRepository
import com.afares.foody.util.Constants.Companion.API_KEY
import com.afares.foody.util.Constants.Companion.DEFAULT_DIET_TYPE
import com.afares.foody.util.Constants.Companion.DEFAULT_MEAL_TYPE
import com.afares.foody.util.Constants.Companion.DEFAULT_RECIPES_NUMBER
import com.afares.foody.util.Constants.Companion.QUERY_ADD_RECIPE_INFORMATION
import com.afares.foody.util.Constants.Companion.QUERY_API_KEY
import com.afares.foody.util.Constants.Companion.QUERY_DIET
import com.afares.foody.util.Constants.Companion.QUERY_FILL_INGREDIENTS
import com.afares.foody.util.Constants.Companion.QUERY_NUMBER
import com.afares.foody.util.Constants.Companion.QUERY_TYPE
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RecipesViewModel @ViewModelInject constructor(
        application: Application,
        private val dataStoreRepository: DataStoreRepository
) : AndroidViewModel(application) {

    private var mealType = DEFAULT_MEAL_TYPE
    private var dietType = DEFAULT_DIET_TYPE

    val readMealAndDietType = dataStoreRepository.readMealAndDietType

    fun saveMealAndDietType(mealType: String, mealTypeId: Int, dietType: String, dietTypeId: Int) {
        viewModelScope.launch(IO) {
            dataStoreRepository.saveMealAndDietType(mealType, mealTypeId, dietType, dietTypeId)
        }
    }

    fun applyQueries(): HashMap<String, String> {
        val queries: HashMap<String, String> = HashMap()

        viewModelScope.launch {
            readMealAndDietType.collect { value ->
                mealType = value.selectedMealType
                dietType = value.selectedDietType
            }
        }

        queries[QUERY_NUMBER] = DEFAULT_RECIPES_NUMBER
        queries[QUERY_API_KEY] = API_KEY
        queries[QUERY_TYPE] = mealType
        queries[QUERY_DIET] = dietType
        queries[QUERY_ADD_RECIPE_INFORMATION] = "true"
        queries[QUERY_FILL_INGREDIENTS] = "true"

        return queries
    }

}
package com.grdj.foodideas.data

import com.grdj.foodideas.R

class FoodMenuItems {
    data class FoodCategory(val image: Int, val name: String )

    object SampleData {
        val foodCategories = listOf(
            FoodCategory(
                R.drawable.chicken_ico,
                "Chicken"
            ),
            FoodCategory(
                R.drawable.espaguetis_ico,
                "Spagueties"
            ),
            FoodCategory(
                R.drawable.meat_ico,
                "Meat"
            ),
            FoodCategory(
                R.drawable.pizza_ico,
                "Pizza"
            ),
            FoodCategory(
                R.drawable.salad_ico,
                "Salad"
            ),
            FoodCategory(
                R.drawable.tacos_ico,
                "Tacos"
            )
        )
    }
}
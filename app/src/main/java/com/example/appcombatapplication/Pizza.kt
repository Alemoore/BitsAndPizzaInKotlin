package com.example.appcombatapplication
val pizzaArray = arrayOf(
    Pizza("Diavolo", R.drawable.diavolo),
    Pizza("Funghi", R.drawable.funghi)
)

data class Pizza(val name: String, val imageSourceId: Int) {
}
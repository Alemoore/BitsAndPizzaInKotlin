package com.example.appcombatapplication


val pastaArray = arrayOf(
    Pasta("Bolognese", R.drawable.bolognese),
    Pasta("Lasagne", R.drawable.lasagne))

data class Pasta(val name: String, val imageResourceId: Int) {}
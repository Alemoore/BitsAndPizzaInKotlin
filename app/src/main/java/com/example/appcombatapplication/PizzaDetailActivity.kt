package com.example.appcombatapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_pizza_detail.*

const val PIZZA_ID = "id"

class PizzaDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_detail)
        setSupportActionBar(toolbar as Toolbar)
        val actionBar = supportActionBar as ActionBar
        actionBar.setDisplayHomeAsUpEnabled(true)
        val pizzaId = intent.extras.getInt(PIZZA_ID)
        val pizzaName : String = pizzaArray[pizzaId].name
        pizza_text.text = pizzaName
        val pizzaImage: Int = pizzaArray[pizzaId].imageSourceId
        pizza_image.setImageDrawable(ContextCompat.getDrawable(this, pizzaImage))
        pizza_image.contentDescription = pizzaName

    }
}
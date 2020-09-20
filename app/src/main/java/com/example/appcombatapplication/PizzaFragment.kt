package com.example.appcombatapplication

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PizzaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pizzaRecycler =
            inflater.inflate(R.layout.fragment_pizza, container, false) as RecyclerView
        val pizzaNames = arrayOfNulls<String>(pizzaArray.size)
        for (i in 0..pizzaArray.size - 1) {
            pizzaNames[i] = pizzaArray[i].name
        }
        val pizzaImages = arrayOfNulls<Int>(pizzaArray.size)
        for (i in 0..pizzaArray.size - 1) {
            pizzaImages[i] = pizzaArray[i].imageSourceId
        }
        val adapter = CaptionedImageAdapter(pizzaNames, pizzaImages)
        pizzaRecycler.adapter = adapter
        val layoutManager = GridLayoutManager(activity, 2)
        pizzaRecycler.layoutManager = layoutManager
        adapter.listener = object: Listener {
            override fun onClick(position: Int) {
                val intent = Intent(activity, PizzaDetailActivity::class.java)
                intent.putExtra(PIZZA_ID, position)
                activity?.startActivity(intent)
            }
        }
        return pizzaRecycler
    }

}
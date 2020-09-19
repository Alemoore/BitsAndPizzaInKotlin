package com.example.appcombatapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_order.*

class CreateOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_order)
        setSupportActionBar(toolbar as Toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    fun onClickDone(view: View) {
        val text = "Your order was added"
        val snackbar = Snackbar.make(coordinator, text,Snackbar.LENGTH_LONG)
        snackbar.setAction("Undo", View.OnClickListener {view ->
            Toast.makeText(this, "Your order was cancelled", Toast.LENGTH_LONG).show()
        })
        snackbar.show()
    }
}

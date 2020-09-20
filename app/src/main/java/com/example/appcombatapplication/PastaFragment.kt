package com.example.appcombatapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class PastaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pastaRecycler = inflater.inflate(R.layout.fragment_pasta, container, false) as RecyclerView
        val pastaNames = arrayOfNulls<String>(pastaArray.size)
        val pastaImages = arrayOfNulls<Int>(pastaArray.size)

        for (i in pastaArray.indices) {
            pastaNames[i] = pastaArray[i].name
            pastaImages[i] = pastaArray[i].imageResourceId
        }

        val adapter = CaptionedImageAdapter(pastaNames, pastaImages)
        val layoutManager = GridLayoutManager(context, 2)
        pastaRecycler.adapter = adapter
        pastaRecycler.layoutManager = layoutManager
        return pastaRecycler
    }
}
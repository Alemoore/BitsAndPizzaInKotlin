package com.example.appcombatapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.widget.ShareActionProvider
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.view.MenuItemCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar as Toolbar)
        val viewPager = SectionsPagerAdapter(supportFragmentManager)
        pager.adapter = viewPager
        tabs.setupWithViewPager(pager)
    }

    private lateinit var shareActionProvider: ShareActionProvider

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val menuItem = menu!!.findItem(R.id.action_share)
        shareActionProvider = MenuItemCompat.getActionProvider(menuItem) as ShareActionProvider
        setShareActionIntent(getString(R.string.share_intent_text))
        return super.onCreateOptionsMenu(menu)
    }

    private fun setShareActionIntent(text: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, text)
        shareActionProvider.setShareIntent(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.action_create_order -> {
                startActivity(Intent(this, CreateOrderActivity::class.java))
                return true
            }
            else ->
                return super.onOptionsItemSelected(item)
        }
    }

    private inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getCount(): Int {
            return 4
        }

        override fun getItem(p0: Int): Fragment {
            return when(p0) {
                0 -> TopFragment()
                1 -> PizzaFragment()
                2 -> PastaFragment()
                3 -> StoresFragment()
                else -> throw IllegalArgumentException("This page doesn't exist")
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> resources.getText(R.string.home_tab)
                1 -> resources.getText(R.string.pizza_tab)
                2 -> resources.getText(R.string.pasta_tab)
                3 -> resources.getText(R.string.store_tab)
                else -> throw java.lang.IllegalArgumentException("This page doesn't exist")
            }
        }
    }
}
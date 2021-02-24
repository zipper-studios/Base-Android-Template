package com.base_android_template

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.base_android_template.shared.Locales
import com.base_android_template.utils.language.LocaleUtils
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.Locale


class MainActivity : AppCompatActivity() {

    init {
        LocaleUtils.updateConfig(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpNavigation()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.language_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.english -> {
                LocaleUtils.setLocale(Locale(Locales.ENGLISH))
                recreate()
                true
            }
            R.id.romanian -> {
                LocaleUtils.setLocale(Locale(Locales.ROMANIAN))
                recreate()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setUpNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment?
        navHostFragment?.navController?.let {
            NavigationUI.setupWithNavController(
                bottomNavigationView,
                it
            )
        }
    }

}
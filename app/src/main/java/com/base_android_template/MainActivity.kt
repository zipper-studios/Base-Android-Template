package com.base_android_template

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.base_android_template.shared.Locales
import com.base_android_template.utils.language.LocaleUtils
import java.util.Locale


class MainActivity : AppCompatActivity() {

    init {
        LocaleUtils.updateConfig(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
}
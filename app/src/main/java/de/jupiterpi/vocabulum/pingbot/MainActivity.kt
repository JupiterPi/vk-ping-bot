package de.jupiterpi.vocabulum.pingbot

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.commit
import de.jupiterpi.vocabulum.pingbot.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // disable night mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        /*binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)*/
        setContentView(R.layout.activity_main)

        /*setSupportActionBar(binding.toolbar)*/
        setSupportActionBar(findViewById(R.id.toolbar))

        /*binding.buttonManualPing*/findViewById<Button>(R.id.button_manual_ping).setOnClickListener {
            Snackbar
                .make(it, "Text", 2000)
                .show()
        }

        /*val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)*/

        if (savedInstanceState == null) {
            /*supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.result_fragments_container, ResultFragment.newInstance("This isn't the last."), "1")
                add(R.id.result_fragments_container, ResultFragment.newInstance("Neither is this."), "2")
            }*/
            /*supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.result_fragments_container, ResultFragment::class.java, Bundle().apply {
                    putString(ARG_RESULT_TEXT, "Not a placeholder anymore!")
                })
            }*/
        }

        addResult("hii")
        findViewById<Button>(R.id.button_manual_ping).setOnClickListener {
            addResult("hi")
        }
    }

    fun addResult(resultText: String) {
        val container = findViewById<LinearLayout>(R.id.results_container)
        val view = layoutInflater.inflate(R.layout.result_container, null)
        view.findViewById<TextView>(R.id.text_result).text = resultText
        container.addView(view, 0)
    }
}
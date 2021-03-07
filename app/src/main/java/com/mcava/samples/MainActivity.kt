package com.mcava.samples

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.setSupportActionBar(this.toolbar)

        val navController = findNavController(R.id.nav_host_fragment).apply { setGraph(R.navigation.nav_graph) }

//        this.appBarConfiguration = AppBarConfiguration(navController.graph)

        this.appBarConfiguration = AppBarConfiguration(
            setOf(R.id.home_dest, R.id.settings_dest)
        )

        this.setupActionBar(navController, appBarConfiguration)
        this.setupBottomNavMenu(navController)
    }

    private fun setupActionBar(navController: NavController, appBarConfiguration: AppBarConfiguration) {
        setupActionBarWithNavController(navController, appBarConfiguration)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val ret = super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.overflow_menu, menu)
        return ret
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // naviga se trova item menu con id che fa match con una destinazione
        return item.onNavDestinationSelected(findNavController(R.id.nav_host_fragment)) || super.onOptionsItemSelected(item)
    }

    private fun setupBottomNavMenu(navController: NavController) {
        // anche qua se trova menu id e destination che matchano fa tutto lui
        this.bottom_nav_view?.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id) {
                R.id.home_dest, R.id.settings_dest -> this.bottom_nav_view.visibility = View.VISIBLE
                else -> this.bottom_nav_view.visibility = View.GONE
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}
package com.example.sunrise.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.sunrise.R
import com.example.sunrise.ui.desk.DeskFragment
import com.example.sunrise.ui.login.LoginFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.IllegalArgumentException

class ApplicationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_application)


        val bottomNavigateView = findViewById<BottomNavigationView>(R.id.navigation)
        bottomNavigateView.setOnNavigationItemSelectedListener {

            when(it.itemId){
                R.id.navigation_desk -> showDeskScreen()
                R.id.navigation_profile -> showProfileScreen()
                R.id.navigation_notifications ->showNotificationsScreen()
                else -> throw IllegalArgumentException()
            }
        }

        if(savedInstanceState == null){
            startApp()
        }

    }

    fun startApp(){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, LoginFragment())
            .commit()
    }





    public fun showDeskScreen() : Boolean{
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, DeskFragment())
        return true
    }

    fun showNotificationsScreen(): Boolean{
        TODO()
    }

    fun showProfileScreen(): Boolean{
        TODO()
    }

    public fun showRegistrationScreen(){
        TODO()
    }


}
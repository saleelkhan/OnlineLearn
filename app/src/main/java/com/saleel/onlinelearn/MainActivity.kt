package com.saleel.onlinelearn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.saleel.onlinelearn.fragments.HomeFragment
import com.saleel.onlinelearn.fragments.NewfeedsFragment
import com.saleel.onlinelearn.fragments.StoreFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setTitle(null)
        toolbar.setNavigationIcon(R.drawable.ic_action_name)
        bottom_navigation_view.setOnNavigationItemSelectedListener(mOnNavigationSelctor)

    }
    private val mOnNavigationSelctor=object :BottomNavigationView.OnNavigationItemSelectedListener{
        override fun onNavigationItemSelected(p0: MenuItem): Boolean {
            when(p0.itemId){
                R.id.store ->{
                    Log.d("SPLASH SCREEN", "store" );
                    addFragment(StoreFragment())
                    return true
                }
                R.id.home ->{
                    Log.d("SPLASH SCREEN", "home" );
                    addFragment(HomeFragment())
                    return true
                }
                R.id.newsfeed ->{
                    Log.d("SPLASH SCREEN", "newsfeed" );
                    addFragment(NewfeedsFragment())
                    return true
                }
            }
            return false
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_item,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =when(item.itemId) {
        R.id.user_info -> {
            Log.d("SPLASH SCREEN", "user_info" );
            true
        }R.id.refresh->{
            Log.d("SPLASH SCREEN", "refresh" );
            true
        }
        else ->{
            super.onOptionsItemSelected(item)
        }
    }
    fun addFragment( frg:Fragment){
        val manager = supportFragmentManager
        val transection =manager.beginTransaction()
        transection.replace(R.id.fragment_container,frg)
        transection.addToBackStack(null)
        transection.commit()
    }
}

package com.moony.petsgo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.moony.feed.FeedFragment
import com.moony.petsgo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.commit {
            add(R.id.fragment_container,FeedFragment())
        }
    }
}
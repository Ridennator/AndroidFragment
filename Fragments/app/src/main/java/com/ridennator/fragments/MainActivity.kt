package com.ridennator.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var f1:Fragment1
    lateinit var f2:Fragment1
    lateinit var f3:Fragment1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        f1=Fragment1.newInstance("Halo","world")
        f2=Fragment1.newInstance("Beep","Boop")
        f3=Fragment1.newInstance("Tarn","ation")

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment1,f1)
        fragmentTransaction.add(R.id.fragment2,f2)
        fragmentTransaction.add(R.id.fragment3,f3)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()


    }
}
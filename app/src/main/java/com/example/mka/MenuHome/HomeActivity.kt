package com.example.mka.MenuHome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mka.R
import com.example.mka.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Menu())

        binding.bottomNavigationView.setOnItemSelectedListener{

            when(it.itemId){

                R.id.menu -> replaceFragment(Menu())
                R.id.sertifikat -> replaceFragment(Sertifikat())
                R.id.laporan -> replaceFragment(Laporan())
                R.id.peserta -> replaceFragment(Peserta())
                R.id.profil -> replaceFragment(Profil())

                else -> {

                }
            }

            true
        }

    }
    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}
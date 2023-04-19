package com.example.mka.LoginRegister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mka.databinding.ActivityLupaKataSandiBinding


class LupaKataSandiActivity : AppCompatActivity() {
    lateinit var binding: ActivityLupaKataSandiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLupaKataSandiBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.kirimlupakatasandi.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
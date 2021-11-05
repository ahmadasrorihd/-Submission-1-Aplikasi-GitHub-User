package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.databinding.ActivityMainBinding
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private val binding: ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val animSlide = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.slide
        )
        binding.ivLogo.animation = animSlide
        val splashTread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(2000)
                } catch (e: InterruptedException) {
                    // do nothing
                } finally {
                    val i = Intent(this@SplashScreenActivity, MainActivity::class.java)
                    startActivity(i)
                    finish()
                }
            }
        }
        splashTread.start()
    }
}